package com.safewoman.safewoman.controller;

import com.safewoman.safewoman.dto.request.ReportRequest;
import com.safewoman.safewoman.dto.response.ReportResponse;
import com.safewoman.safewoman.entities.Report;
import com.safewoman.safewoman.service.ReportService;
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

    @PostMapping("/create/report")
    public ReportResponse create (@Valid @RequestBody ReportRequest request){
        ReportResponse response = reportService.register(request);
        return response;
    }
    @GetMapping("report/city/{city}")
    public ResponseEntity<List<ReportRequest>> findByCity(@Valid @PathVariable String city){
        return ResponseEntity.ok(reportService.findByCity(city));
    }
    @GetMapping("report/state/{state}")
    public ResponseEntity<List<ReportRequest>> findByState(@Valid @PathVariable String state){
        return ResponseEntity.ok(reportService.findByState(state));
    }
    @GetMapping("report/offensetype/{offensetype}")
    public ResponseEntity<List<ReportRequest>> findByOffenseType(@Valid @PathVariable String offensetype){
        return ResponseEntity.ok(reportService.findByOffenseType(offensetype));
    }

    @GetMapping
    public ResponseEntity<List<ReportResponse>> findAllReports(){
        return ResponseEntity.ok(reportService.findAll());
    }

}
