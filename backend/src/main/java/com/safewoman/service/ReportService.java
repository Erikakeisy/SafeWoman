package com.safewoman.service;

import com.safewoman.entities.Report;
import com.safewoman.repository.ReportRepository;
import com.safewoman.dto.request.ReportRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ReportRepository reportRepository;

    public Report register(ReportRequest request){
        Report report = modelMapper.map(request, Report.class);
        this.reportRepository.save(report);
        return report;
    }

    public List<Report> findByCity(String city){
        List<Report> result = new ArrayList<>();
        List<Report> findByCity = reportRepository.findByCity(city);
        if (!findByCity.isEmpty()){
            findByCity.forEach(f -> result.add(modelMapper.map(f, Report.class)));
        }
        return result;
    }

    public List<Report> findByState(String state){
        List<Report> result = new ArrayList<>();
        List<Report> findByState = reportRepository.findByState(state);
        if (!findByState.isEmpty()){
            findByState.forEach(f -> result.add(modelMapper.map(f, Report.class)));
        }
        return result;
    }

    public List<Report> findByOffenseType(String offensetype){
        List<Report> result = new ArrayList<>();
        List<Report> findByOffenseType = reportRepository.findByOffenseType(offensetype);
        if (!findByOffenseType.isEmpty()){
            findByOffenseType.forEach(f -> result.add(modelMapper.map(f, Report.class)));
        }
        return result;
    }

    public List<Report> findAll() {
        List<Report> report = reportRepository.findAll();
        return report.stream().map(r -> modelMapper.map(r, Report.class)).collect(Collectors.toList());
    }
}
