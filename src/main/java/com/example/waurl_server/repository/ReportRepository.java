package com.example.waurl_server.repository;

import com.example.waurl_server.entity.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReportRepository extends CrudRepository<Report, Long> {
    Optional<Report> findByUrl(String url);
}
