package com.example.waurl_server.repository;

import com.example.waurl_server.entity.NotSure;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface NotSureRepository extends CrudRepository<NotSure, Long> {
    Optional<NotSure> findByUrl(String url);

    List<NotSure> findAllByOrderByReportCountDesc(Sort sort);
}
