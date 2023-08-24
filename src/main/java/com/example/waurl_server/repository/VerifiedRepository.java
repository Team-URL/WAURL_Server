package com.example.waurl_server.repository;

import com.example.waurl_server.entity.Verified;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VerifiedRepository extends CrudRepository<Verified, Long> {
    Optional<Verified> findByUrl(String url);

}
