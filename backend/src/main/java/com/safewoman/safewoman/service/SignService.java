package com.safewoman.safewoman.service;

import com.safewoman.safewoman.entities.Sign;
import com.safewoman.safewoman.repository.SignRepository;
import com.safewoman.safewoman.dto.request.SignRequest;
import com.safewoman.safewoman.dto.response.SignResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    SignRepository signRepository;
    private Object ValideCpf;

    public SignResponse register(SignRequest request){
        Sign sign = modelMapper.map(request, Sign.class);
        valideCpfandEmail(request);
        this.signRepository.save(sign);
        return modelMapper.map(sign, SignResponse.class);
    }

    private void valideCpfandEmail(SignRequest request){
        Optional<Sign> sign = signRepository.findByCpf(request.getCpf());
            if(sign.isPresent() && sign.get().getCpf() != request.getCpf()){
        throw new DataIntegrityViolationException("CPF already registered in our system");
        }
        sign = signRepository.findByEmail(request.getEmail());
            if (sign.isPresent() && sign.get().getEmail() != request.getEmail()){
                throw new DataIntegrityViolationException("Email already registered in our system");
            }
        }
    }

