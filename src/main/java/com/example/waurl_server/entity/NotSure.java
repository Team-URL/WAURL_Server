package com.example.waurl_server.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class NotSure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String url;

    @Column
    private int reportCount;

    public NotSure() {
    }

    public NotSure(Long id, String url, int reportCount) {
        this.id = id;
        this.url = url;
        this.reportCount = reportCount;
    }

}
