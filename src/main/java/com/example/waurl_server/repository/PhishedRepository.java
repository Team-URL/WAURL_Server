package com.example.waurl_server.repository;

import com.example.waurl_server.entity.Phished;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PhishedRepository extends CrudRepository<Phished, Long> {
    Optional<Phished> findByUrl(String url);
}
