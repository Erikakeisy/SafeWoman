package com.safewoman.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safewoman.dto.CredentialDTO;
import com.safewoman.entities.User;
import com.safewoman.exception.UserNotFoundException;
import com.safewoman.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;
    private JWTUtil jwtUtil;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            CredentialDTO credentialDTO = new ObjectMapper().readValue(request.getInputStream(), CredentialDTO.class);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
                    (credentialDTO.getEmail(), credentialDTO.getPassword(), new ArrayList<>());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            return authentication;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String email = ((UserSS) authResult.getPrincipal()).getUsername();
        String token = jwtUtil.generateToken(email);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        response.setHeader("Authorization", "Bearer " + token);
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User Not Found"));
       response.setHeader("userId", user.getUserId().toString());
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
                response.setStatus(401);
                response.setContentType("application/json");
                response.getWriter().append(json());

    }
    private CharSequence json(){
        long date = new Date().getTime();
        return "{"
                + "\"timestamp\" : " + date + ","
                + "\"status\" :401, "
                + "\"error\": \"Não autorizado\", "
                + "\"message\": \"Email ou senha inválidos\", "
                + "\"path\": \"/login\"}";
    }

}
