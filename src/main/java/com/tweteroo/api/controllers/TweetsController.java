package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tweets")
public class TweetsController {

    @PostMapping
    public void create(){
        System.out.println("Tweet created");
    }

    @GetMapping
    public void get(){
        System.out.println("Tweet get");
    }

    @GetMapping("/{username}")
    public void getTweetsByUsername(@PathVariable String username){
        System.out.println("Tweet get by " + username);
    }
}
