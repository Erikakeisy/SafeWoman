package com.safewoman.controller;

import com.safewoman.entities.User;
import com.safewoman.repository.UserRepository;
import com.safewoman.service.UserService;
import com.safewoman.dto.request.UserRequest;
import com.safewoman.dto.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/safewoman")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/list")
    public ResponseEntity<List<UserResponse>> findAll(){
        List<UserResponse> response = userService.findAll();
        return ResponseEntity.ok(response);
    }
    @PostMapping("/user/register")
    public UserResponse create (@Valid @RequestBody UserRequest request){
        UserResponse response = userService.register(request);
        return response;
    }

    @GetMapping("/user/name/{name}")
    public ResponseEntity<List<UserRequest>> findByName(@Valid @PathVariable String name){
        return ResponseEntity.ok(userService.findByName(name));
    }

    @GetMapping("/user/id/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id){
        UserResponse request = userService.findById(id);
        return ResponseEntity.ok(request);
    }

    @DeleteMapping("/user/deleteId/{id}")
    public void delete (@PathVariable Long id){
        userService.delete(id);
    }

    @DeleteMapping("/user/delete")
    public void deleteUser (@RequestBody User user){
        userRepository.delete(user);
    }

    @PatchMapping("user/update/{id}")
    public ResponseEntity<UserResponse> updateById(@PathVariable Long id, @RequestBody UserRequest userRequest){
        UserResponse request = userService.updateUser(id, userRequest);
        return ResponseEntity.ok(request);
    }



}
