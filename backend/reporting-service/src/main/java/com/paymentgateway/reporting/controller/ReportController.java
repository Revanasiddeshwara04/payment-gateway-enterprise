package com.paymentgateway.reporting.controller;

import com.paymentgateway.reporting.dto.DashboardResponse;
import com.paymentgateway.reporting.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(
            ReportService reportService) {

        this.reportService = reportService;
    }

    @GetMapping("/dashboard")
    public DashboardResponse dashboard() {

        return reportService.getDashboard();
    }
}