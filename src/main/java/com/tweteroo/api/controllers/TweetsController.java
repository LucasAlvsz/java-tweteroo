package com.tweteroo.api.controllers;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.erros.NotFoundError;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.services.TweetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tweets")
public class TweetsController {

    private final TweetsService tweetsService;
    @Autowired
    public TweetsController(TweetsService tweetsService) {
        this.tweetsService = tweetsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TweetDTO req) throws NotFoundError {
        tweetsService.saveTweet(req);
    }

    @GetMapping
    public List<TweetModel> getAllTweets(){
        return tweetsService.getAllTweets();
    }

    @GetMapping("/{username}")
    public List<TweetModel> getTweetsByUsername(@PathVariable String username){
        return tweetsService.getTweetsByUsername(username);
    }
}
