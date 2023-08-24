package com.example.waurl_server.controller;

import com.example.waurl_server.entity.Verified;
import com.example.waurl_server.repository.VerifiedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/verified")
@RequiredArgsConstructor
public class VerifiedController {
    private final VerifiedRepository verifiedRepository;


    @GetMapping("list")
    public List<Verified> findAll() {
        return (List<Verified>) verifiedRepository.findAll();
    }

    @GetMapping("find")
    public Optional<Verified> findByUrl(@RequestParam("url") String url) {
        return verifiedRepository.findByUrl(url);
    }

}
