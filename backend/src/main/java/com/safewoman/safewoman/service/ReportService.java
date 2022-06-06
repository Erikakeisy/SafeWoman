package com.safewoman.safewoman.service;

import com.safewoman.safewoman.entities.Report;
import com.safewoman.safewoman.repository.ReportRepository;
import com.safewoman.safewoman.dto.request.ReportRequest;
import com.safewoman.safewoman.dto.response.ReportResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ReportRepository reportRepository;

    public ReportResponse register(ReportRequest request){
        Report report = modelMapper.map(request, Report.class);
        this.reportRepository.save(report);
        return modelMapper.map(report, ReportResponse.class);
    }

    public List<ReportRequest> findByCity(String city){
        List<ReportRequest> result = new ArrayList<>();
        List<Report> findByCity = reportRepository.findByCity(city);
        if (!findByCity.isEmpty()){
            findByCity.forEach(f -> result.add(modelMapper.map(f, ReportRequest.class)));
        }
        return result;
    }

    public List<ReportRequest> findByState(String state){
        List<ReportRequest> result = new ArrayList<>();
        List<Report> findByState = reportRepository.findByState(state);
        if (!findByState.isEmpty()){
            findByState.forEach(f -> result.add(modelMapper.map(f, ReportRequest.class)));
        }
        return result;
    }

    public List<ReportRequest> findByOffenseType(String offensetype){
        List<ReportRequest> result = new ArrayList<>();
        List<Report> findByOffenseType = reportRepository.findByOffenseType(offensetype);
        if (!findByOffenseType.isEmpty()){
            findByOffenseType.forEach(f -> result.add(modelMapper.map(f, ReportRequest.class)));
        }
        return result;
    }
}
