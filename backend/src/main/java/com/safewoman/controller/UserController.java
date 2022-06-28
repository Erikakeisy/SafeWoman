package com.safewoman.controller;

import com.safewoman.dto.request.CreateNewUserRequest;
import com.safewoman.dto.response.CreateNewUserResponse;
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

    //Rota de cadastro simples
    @PostMapping("/user/create")
    public ResponseEntity<CreateNewUserResponse> createNewUser(@RequestBody CreateNewUserRequest request){
        CreateNewUserResponse response = userService.createNewUser(request);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/user/{id}")
    public void delete (@PathVariable Long id){
        userService.delete(id);
    }


    @PatchMapping("user/{id}")
    public ResponseEntity<UserResponse> updateById(@PathVariable Long id, @RequestBody UserRequest userRequest){
        UserResponse request = userService.updateUser(id, userRequest);
        return ResponseEntity.ok(request);
    }



}
