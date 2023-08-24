package com.example.waurl_server.repository;

import com.example.waurl_server.entity.NotSure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NotSureRepository extends CrudRepository<NotSure, Long> {
    Optional<NotSure> findByUrl(String url);
}
