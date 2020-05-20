package sda.twitterAtSDA.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sda.twitterAtSDA.model.dto.CreateUserDto;
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

    public void addUser(CreateUserDto createUserDto) {
        User user = mapper.map(createUserDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void findUserById(Long id) {
        userRepository.findById(id);
    }

    public List<CreateUserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> mapper.map(user, CreateUserDto.class))
                .collect(Collectors.toList());
    }

    public List<CreateUserDto> getUsersByName(String name){
        return getAllUsers().stream()
                .filter(userDto -> userDto.getName().equals(name))
                .collect(Collectors.toList());
    }
}
