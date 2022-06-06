package com.safewoman.safewoman.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportRequest {

    private String city;

    private String state;

    private String street;

    private String hour;

    private String neighborhood;

    private String date;

    private String offenseType;

    private boolean alone;

    private String offenseParticulars;

    private String offenseLocation;

    private boolean policeReport;

    private boolean policeSolved;

    private String policeReportParticulars;

    private String suspectParticulars;

    private String observation;

//    private User user;
}
