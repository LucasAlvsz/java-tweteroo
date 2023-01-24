package com.tweteroo.api.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TweetModel {

    public TweetModel() {
    }
    public TweetModel(String content, UserModel user) {
        this.content = content;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 280)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;


}
