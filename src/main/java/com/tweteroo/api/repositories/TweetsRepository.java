package com.tweteroo.api.repositories;

import com.tweteroo.api.models.TweetModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetsRepository extends JpaRepository<TweetModel, Long> {

    public List<TweetModel> findByUserUsername(String username);
}
