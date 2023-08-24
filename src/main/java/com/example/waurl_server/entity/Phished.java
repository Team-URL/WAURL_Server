package com.example.waurl_server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Phished {
    @Id
    @Column
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String url;

    public Phished() {
    }

    public Phished(Long id, String url) {
        this.id = id;
        this.url = url;
    }
}
