package com.safewoman.service;

import com.safewoman.dto.request.UserRequest;
import com.safewoman.entities.User;
import com.safewoman.repository.UserRepository;
import com.safewoman.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void createNewUser() throws IOException {
        UserRequest newUser = TestUtils.getObjectFromJsonFile("json/UserRequest.json", UserRequest.class);
        User user = TestUtils.getObjectFromJsonFile("json/UserRequest.json", User.class);
        userRepository.save(user);
        when(userService.createNewUser(newUser)).thenReturn(new User());
        when(userRepository.save(user)).thenReturn(new User());

        verify(userRepository, times(1)).save(any(User.class));

    }
}
