package com.safewoman.controller;

import com.safewoman.entities.User;
import com.safewoman.repository.UserRepository;
import com.safewoman.service.UserService;
import com.safewoman.dto.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/states")
    public ResponseEntity<List<User>> findAll(){
        List<User> response = userService.findAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/user/create")
    public ResponseEntity<User> createNewUser(@RequestBody UserRequest request){
        User response = userService.createNewUser(request);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/user/{id}")
    public void delete (@PathVariable Long id){
        userService.delete(id);
    }


    @PatchMapping("user/{id}")
    public ResponseEntity<User> updateById(@PathVariable Long id, @RequestBody UserRequest userRequest){
        User request = userService.updateUser(id, userRequest);
        return ResponseEntity.ok(request);
    }



}
