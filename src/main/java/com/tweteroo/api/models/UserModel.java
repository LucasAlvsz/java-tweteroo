package com.tweteroo.api.models;

import com.tweteroo.api.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class UserModel {

    public UserModel() {
    }

    public UserModel(UserDTO userData) {
        this.username = userData.username();
        this.avatar = userData.avatar();
    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 50)
    private String username;
    @Column(nullable = false)
    private String avatar;


}
