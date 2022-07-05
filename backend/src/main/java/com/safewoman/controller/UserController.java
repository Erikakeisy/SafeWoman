package com.safewoman.controller;

import com.safewoman.dto.request.UserUpdateRequest;
import com.safewoman.entities.User;
import com.safewoman.repository.UserRepository;
import com.safewoman.service.UserService;
import com.safewoman.dto.request.UserRequest;
import com.sun.xml.bind.v2.TODO;
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

    @GetMapping("user/findById/{userId}")
    public ResponseEntity<User> findById(@PathVariable Long userId){
        User user = userService.findById(userId);
        return ResponseEntity.ok(user);

    }

    @PostMapping("user/create")
    public ResponseEntity<User> createNewUser(@RequestBody UserRequest request){
        User response = userService.createNewUser(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("user/delete/{userId}")
    public ResponseEntity<?> delete (@PathVariable Long userId){
        userService.delete(userId);
        return ResponseEntity.ok("User with useId: "  + userId + " delete with sucessful");
    }

    @PutMapping("user/{userId}")
    public ResponseEntity<User> updateById(@PathVariable Long userId, @RequestBody UserUpdateRequest userRequest){
        User request = userService.updateUser(userId, userRequest);
        return ResponseEntity.ok(request);
    }

}
