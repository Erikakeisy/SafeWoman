package com.safewoman.controller;

import com.safewoman.dto.request.ReportRequest;
import com.safewoman.entities.Report;
import com.safewoman.service.ReportService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/safewoman")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("report/create")
    public Report create(@Valid @RequestBody ReportRequest request) {
        Report response = reportService.register(request);
        return response;
    }

    @GetMapping("report/findById/{reportId}")
    public ResponseEntity<Report> findReportById(@PathVariable Long reportId){
        Report report = reportService.findById(reportId);
        return ResponseEntity.ok(report);
    }

    @GetMapping("report/city/{city}")
    public ResponseEntity<List<Report>> findByCity(@Valid @PathVariable String city) {
        return ResponseEntity.ok(reportService.findByCity(city));
    }

    @GetMapping("report/state/{state}")
    public ResponseEntity<List<Report>> findByState(@Valid @PathVariable String state) {
        return ResponseEntity.ok(reportService.findByState(state));
    }

    @GetMapping("report/offensetype/{offensetype}")
    public ResponseEntity<List<Report>> findByOffenseType(@Valid @PathVariable String offensetype) {
        return ResponseEntity.ok(reportService.findByOffenseType(offensetype));
    }

    @GetMapping("report/findAll")
    public ResponseEntity<List<Report>> findAllReports() {
        return ResponseEntity.ok(reportService.findAll());
    }

    @PatchMapping("report/update/{reportId}")
    public ResponseEntity<Report> updateReportById(@Valid @PathVariable Long reportId, @RequestBody ReportRequest reportRequest) {
        return ResponseEntity.ok(reportService.updateReportById(reportId, reportRequest));
    }

    @DeleteMapping("report/delete/{reportId}")
    public ResponseEntity<?>deleteReportById(@Valid @PathVariable Long reportId) {
        reportService.deleteReportById(reportId);
        return ResponseEntity.ok("Report delete with sucess");
    }

}
