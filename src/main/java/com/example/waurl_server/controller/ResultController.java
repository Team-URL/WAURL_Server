package com.example.waurl_server.controller;


import com.example.waurl_server.entity.NotSure;
import com.example.waurl_server.entity.Phished;
import com.example.waurl_server.entity.Result;
import com.example.waurl_server.entity.Verified;
import com.example.waurl_server.repository.NotSureRepository;
import com.example.waurl_server.repository.PhishedRepository;
import com.example.waurl_server.repository.VerifiedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/result")
@RequiredArgsConstructor
public class ResultController {

    private final NotSureRepository notSureRepository;
    private final PhishedRepository phishedRepository;
    private final VerifiedRepository verifiedRepository;


    @GetMapping("get")
    public Result getResult(@RequestParam("url") String url) {
        Optional<NotSure> notSureUrl = notSureRepository.findByUrl(url);
        Optional<Phished> phishedUrl = phishedRepository.findByUrl(url);
        Optional<Verified> verifiedUrl = verifiedRepository.findByUrl(url);

        boolean isSafe = true;
        boolean isDangerous = true;
        int reportCount = 0;

        if (verifiedUrl.isEmpty()){
            isSafe = false;
        }

        if(phishedUrl.isEmpty()){
            isDangerous = false;
        }

        if(!notSureUrl.isEmpty()){
            reportCount = notSureUrl.get().getReportCount();
        }

        Result result = Result.builder()
                .isSafe(isSafe)
                .isDangerous(isDangerous)
                .reportCount(reportCount)
                .url(url)
                .build();

        return result;
    }


}
