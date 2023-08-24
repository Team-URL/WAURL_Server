package com.example.waurl_server.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String email;

    @Column
    private String passWord;

    public User() {}

    public User(String email, String passWord) {
        this.email = email;
        this.passWord = passWord;
    }
}
