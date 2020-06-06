package sda.twitterAtSDA.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sda.twitterAtSDA.exception.UserNotFoundException;
import sda.twitterAtSDA.model.dto.UserDto;
import sda.twitterAtSDA.model.entity.Friendship;
import sda.twitterAtSDA.model.entity.User;
import sda.twitterAtSDA.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private ModelMapper mapper;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(ModelMapper mapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(UserDto userDto) {
        User user = mapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No user with such id"));
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> mapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public UserDto getUserByEmail(String email) {
        return getAllUsers().stream()
                .filter(userDto -> userDto.getEmail().equals(email))
                .findFirst()
                .get();
    }

    public List<UserDto> getUsersByQuery(String query) {
        String[] queryArray = query.split(" ");
        String surnameQuery = queryArray[queryArray.length - 1];
        List<UserDto> usersByQuery = getAllUsers().stream().filter(userDto -> userDto.getSurname().equals(surnameQuery))
                .collect(Collectors.toList());
        if (!usersByQuery.isEmpty()) {
            return usersByQuery;
        } else {
            throw new UserNotFoundException("User not found");
        }

    }
    public void addFriend(Long userId, Long friendId){

        User user = userRepository.findById(userId).get();
        User friend = userRepository.findById(friendId).get();

        user.getFriendship().getFriends().add(friend);
        friend.getFriendship().getFriends().add(user);

        userRepository.save(user);
        userRepository.save(friend);

    }
    public void addFriendTest(){
        User user = new User();
        user.setName("Friend");
        user.setSurname("Bak");
        user.setEmail("adam@domain.com");
        user.setPassword("password");
        user.setDateOfBirth(new Date());
        user.setGender("male");
        user.setRole("ROLE_USER");
        user = userRepository.save(user);

        Friendship friendship1 = new Friendship();
        friendship1.setFriends(Set.of(user));

        User user2 = new User();
        user2.setName("Friend2");
        user2.setSurname("Bak");
        user2.setEmail("adam@domain.com");
        user2.setPassword("password");
        user2.setDateOfBirth(new Date());
        user2.setGender("male");
        user2.setRole("ROLE_USER");
        user2.setFriendship(friendship1);
        user2 = userRepository.save(user2);

        Friendship friendship = new Friendship();
        friendship.setFriends(Set.of(user2, user));



        User user1 = new User();
        user1.setName("User");
        user1.setSurname("Bak");
        user1.setEmail("adam@domain.com");
        user1.setPassword("password");
        user1.setDateOfBirth(new Date());
        user1.setGender("male");
        user1.setRole("ROLE_USER");
        user1.setFriendship(friendship);
        user1 = userRepository.save(user1);

        List<User> user3 = userRepository.findAll();

    }

}
