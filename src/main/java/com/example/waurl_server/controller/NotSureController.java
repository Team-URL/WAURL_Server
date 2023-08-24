package com.example.waurl_server.controller;

import com.example.waurl_server.entity.NotSure;
import com.example.waurl_server.entity.Report;
import com.example.waurl_server.repository.NotSureRepository;
import com.example.waurl_server.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/notSure")
@RequiredArgsConstructor
public class NotSureController {
    private final NotSureRepository notSureRepository;
    private final ReportRepository reportRepository;
    @GetMapping("list")
    public List<NotSure> findAll() {
        return (List<NotSure>) notSureRepository.findAll();
    }

    @GetMapping("find")
    public Optional<NotSure> findByUrl(@RequestParam("url") String url) {
        return notSureRepository.findByUrl(url);
    }

    @PostMapping("new")
    public NotSure createUrl(@RequestParam("url") String url) {

        Optional<NotSure> findUrl = notSureRepository.findByUrl(url);

        if (findUrl.isEmpty()) {
            NotSure notSureUrl = NotSure.builder()
                    .url(url)
                    .reportCount(0)
                    .build();

            notSureRepository.save(notSureUrl);
            return notSureUrl;
        } else {
            NotSure notSureUrl = findUrl.get();
            notSureUrl.setReportCount(notSureUrl.getReportCount() + 1);
            notSureRepository.save(notSureUrl);
            return notSureUrl;
        }
    }

    @PostMapping("accept")
    public NotSure acceptReport(@RequestParam("reportId") Long id) {
        Optional<Report> report = reportRepository.findById(id);
        String url = report.get().getUrl();
        Optional<NotSure> findUrl = notSureRepository.findByUrl(url);

        if (findUrl.isEmpty()) {
            NotSure notSureUrl = NotSure.builder()
                    .url(url)
                    .reportCount(1)
                    .build();

            notSureRepository.save(notSureUrl);
            reportRepository.deleteById(id);
            return notSureUrl;
        } else {
            NotSure notSureUrl = findUrl.get();
            notSureUrl.setReportCount(notSureUrl.getReportCount() + 1);
            notSureRepository.save(notSureUrl);
            reportRepository.deleteById(id);
            return notSureUrl;
        }
    }

    @GetMapping("chart")
    public List<NotSure> showNotSureChart(){
        List<NotSure> notSureChart = notSureRepository.findAllByOrderByReportCountDesc(Sort.by(Sort.Order.asc("reportCount")));

        int limit = 10;
        if (notSureChart.size() > limit) {
            notSureChart = notSureChart.subList(0, limit);
        }

        return notSureChart;
    }
}
