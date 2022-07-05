package com.safewoman.controller;

import com.safewoman.entities.User;
import com.safewoman.repository.UserRepository;
import com.safewoman.service.UserService;
import com.safewoman.dto.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/safewoman")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    //TODO Permission URL for ADMIN
    @GetMapping("user/findAll")
    public ResponseEntity<List<User>> findAll(){
        List<User> response = userService.findAll();
        return ResponseEntity.ok(response);
    }

    //TODO GET USER BY ID
//    @GetMapping("user/findById/{id}")


    @PostMapping("user/create")
    public ResponseEntity<User> createNewUser(@RequestBody UserRequest request){
        User response = userService.createNewUser(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("user/delete/{userId}")
    public void delete (@PathVariable Long userId){
        userService.delete(userId);
    }

//TODO PUT USER
//    @PatchMapping("user/{userId}")
//    public ResponseEntity<User> updateById(@PathVariable Long userId, @RequestBody UserRequest userRequest){
//        User request = userService.updateUser(userId, userRequest);
//        return ResponseEntity.ok(request);
//    }

}
