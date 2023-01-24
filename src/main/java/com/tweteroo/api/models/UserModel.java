package com.tweteroo.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false, length = 50)
    private String username;
    @Column(nullable = false)
    private String avatar;
}
