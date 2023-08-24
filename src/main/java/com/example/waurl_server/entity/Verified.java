package com.example.waurl_server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Verified {
    @Id
    @Column
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String url;

    public Verified() {
    }

    public Verified(Long id, String url) {
        this.id = id;
        this.url = url;
    }
}
