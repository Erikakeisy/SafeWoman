package com.safewoman.safewoman.controller;

import com.safewoman.safewoman.repository.SignRepository;
import com.safewoman.safewoman.service.SignService;
import com.safewoman.safewoman.dto.request.SignRequest;
import com.safewoman.safewoman.dto.response.SignResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/safewoman")
@RestController
public class SignController {

    @Autowired
    SignService signService;

    @Autowired
    SignRepository signRepository;

    @PostMapping("/sign")
    public SignResponse create (@Valid @RequestBody SignRequest request){
        SignResponse response = signService.register(request);
        return response;
    }
}
