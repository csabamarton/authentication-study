package com.csmarton.auth.controller;

import com.csmarton.auth.model.User;
import com.csmarton.auth.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @InjectMocks AuthController authController;

    @Mock
    UserRepository userRepository;

    @Test
    public void testGetUsers() {
        when(userRepository.findAll()).thenReturn(new ArrayList<>());

        List<User> expectedEmptyList = new ArrayList<>();

        List<User> result = userRepository.findAll();

        assertIterableEquals(expectedEmptyList, result);
    }


}