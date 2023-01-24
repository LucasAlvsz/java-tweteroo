package com.tweteroo.api.models;

import jakarta.persistence.*;

public class TweetModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 280)
    private String content;

    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

}
