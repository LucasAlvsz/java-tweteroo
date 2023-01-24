package com.tweteroo.api.controllers;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    @Autowired
    private AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UserDTO req){
        userService.saveUser(req);
    }

    @GetMapping("/users")
    public List<UserModel> getUsers(){
        return userService.getAllUsers();
    }


}

