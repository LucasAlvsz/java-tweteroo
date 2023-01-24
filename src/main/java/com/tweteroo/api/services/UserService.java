package com.tweteroo.api.services;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.erros.NotFoundError;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserDTO userDTO) {
        userRepository.save(new UserModel(userDTO));
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(Long id) throws NotFoundError {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundError("User not found"));
    }

    public UserModel getUserByUsername(String username) throws NotFoundError {
        UserModel user = userRepository.findByUsername(username);
        if (user == null)
            throw new NotFoundError("User: '" + username + "' not found");

        return user;
    }
}
