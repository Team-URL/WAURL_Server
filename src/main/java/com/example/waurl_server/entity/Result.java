package com.example.waurl_server.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Result {

    private String url;

    private boolean isSafe;

    private boolean isDangerous;

    private int reportCount;

    public Result() {
    }

    public Result(String url, boolean isSafe, boolean isDangerous, int reportCount) {
        this.url = url;
        this.isSafe = isSafe;
        this.isDangerous = isDangerous;
        this.reportCount = reportCount;
    }
}
