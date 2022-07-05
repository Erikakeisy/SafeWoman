package com.safewoman.service;

import com.safewoman.dto.constants.Profile;
import com.safewoman.entities.User;
import com.safewoman.exception.ResourceNotFound;
import com.safewoman.repository.UserRepository;
import com.safewoman.dto.request.UserRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;

    public User createNewUser(UserRequest request) {
        User user = modelMapper.map(request, User.class);
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        user.setProfiles(Profile.USER);
        userRepository.save(user);
        return user;
    }

    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFound("Email:" + email + " User was that email not found"));
        return user;
    }

    public List<User> findAll() {
        List<User> user = userRepository.findAll();
        return user.stream().map(c -> modelMapper.map(c, User.class)).collect(Collectors.toList());
    }

    public void delete(@PathVariable Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.deleteById(userId);
        }
    }

    public User updateUser(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        userRepository.save(user);
        return user;

    }

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
