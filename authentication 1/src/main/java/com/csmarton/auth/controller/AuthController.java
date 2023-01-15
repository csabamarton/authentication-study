package com.csmarton.auth.controller;

import com.csmarton.auth.model.User;
import com.csmarton.auth.repository.UserRepository;
import com.csmarton.auth.web.UserRequest;
import com.csmarton.auth.web.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    @GetMapping(value = "/users", produces = "application/json")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = new ArrayList<>();

        try {
            users = userRepository.findAll();

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/user/register")
    UserResponse register(@Valid @RequestBody UserRequest userRequest) {
        User user = new User(userRequest.getUsername(), userRequest.getPassword());

        User userEntity = userRepository.save(user);

        return new UserResponse(userEntity.getId().toString(), userEntity.getUsername());
    }
}
