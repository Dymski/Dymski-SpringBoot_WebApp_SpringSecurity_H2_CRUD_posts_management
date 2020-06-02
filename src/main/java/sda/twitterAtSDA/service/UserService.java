package sda.twitterAtSDA.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sda.twitterAtSDA.exception.UserNotFoundException;
import sda.twitterAtSDA.model.dto.UserDto;
import sda.twitterAtSDA.model.entity.User;
import sda.twitterAtSDA.repository.UserRepository;
import java.util.List;
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

}
