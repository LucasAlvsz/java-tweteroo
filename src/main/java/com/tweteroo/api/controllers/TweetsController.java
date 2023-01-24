package com.tweteroo.api.controllers;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.erros.NotFoundError;
import com.tweteroo.api.erros.UnprocessableEntity;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.services.TweetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
    public List<TweetModel> getAllTweets(@RequestParam(name = "page", defaultValue = "1") int page){
        page = page < 1 ? 1 : page;
        return tweetsService.getAllTweets(page);
    }

    @GetMapping("/{username}")
    public List<TweetModel> getTweetsByUsername(@PathVariable String username) throws NotFoundError {
        return tweetsService.getTweetsByUsername(username);
    }
}
