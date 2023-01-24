package com.tweteroo.api.services;


import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.erros.NotFoundError;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.TweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetsService {
    private final TweetsRepository tweetsRepository;
    private final UserService userService;
    @Autowired
    public TweetsService(TweetsRepository tweetsRepository, UserService userService) {
        this.tweetsRepository = tweetsRepository;
        this.userService = userService;
    }

    public void saveTweet(TweetDTO tweetDTO) throws NotFoundError {
        UserModel user = userService.getUserById(tweetDTO.userId());
        tweetsRepository.save(new TweetModel(tweetDTO.content(), user));
    }

    public List<TweetModel> getAllTweets() {
        return tweetsRepository.findAll();
    }

    public List<TweetModel> getTweetsByUsername(String username) {
        return tweetsRepository.findByUserUsername(username);
    }

}
