package com.tweteroo.api.controllers;

import com.tweteroo.api.dto.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/sign-up")
    public void create(@RequestBody UserDTO req){
        System.out.println(req);
    }


}

