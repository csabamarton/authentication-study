package com.csmarton.auth.service;

import com.csmarton.auth.model.User;
import com.csmarton.auth.repository.UserRepository;
import com.csmarton.auth.validation.UserAlreadyExistsException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Integer saveUser(User user) throws UserAlreadyExistsException {

        User byName = userRepository.findByUsername(user.getUsername());
        if(byName != null) {
            throw new UserAlreadyExistsException(String.format("This user (%s) has been already registered", user.getUsername()));
        }

        User createdUser = userRepository.save(user);
        return createdUser.getId();
    }
}
