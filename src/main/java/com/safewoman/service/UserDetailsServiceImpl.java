package com.safewoman.service;

import com.safewoman.config.security.UserSS;
import com.safewoman.entities.User;
import com.safewoman.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            return new UserSS(user.get().getUserId(), user.get().getEmail(), user.get().getPassword(), Collections.singletonList(user.get().getProfiles()));
        }
        throw new UsernameNotFoundException(email);
    }

    }
