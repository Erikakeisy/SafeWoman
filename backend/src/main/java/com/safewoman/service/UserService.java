package com.safewoman.service;

import com.safewoman.entities.User;
import com.safewoman.exception.ResourceNotFound;
import com.safewoman.repository.UserRepository;
import com.safewoman.dto.request.UserRequest;
import com.safewoman.dto.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.ArrayList;
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

    public UserResponse register(UserRequest request){
        User user = modelMapper.map(request, User.class);
        this.userRepository.save(user);
        return modelMapper.map(user, UserResponse.class);
    }

    public List<UserRequest> findByName(String name){
        List<UserRequest> result = new ArrayList<>();
        List<User> findByName = userRepository.findByName(name);
        if (!findByName.isEmpty()){
            findByName.forEach(f -> result.add(modelMapper.map(f, UserRequest.class)));
        }
        return result;

    }

    public UserResponse findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("ID:" + id + " USER WAS NOT FOUND"));
        return modelMapper.map(user, UserResponse.class);
    }

    public List<UserResponse> findAll(){
        List<User>user = userRepository.findAll();
        return user.stream().map(c -> modelMapper.map(c, UserResponse.class)).collect(Collectors.toList());
    }

    public void delete(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            userRepository.deleteById(id);
        }
    }

    public UserResponse updateUser(Long id, UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        this.userRepository.save(user);
        return modelMapper.map(user, UserResponse.class);

    }
}
