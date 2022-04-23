package com.webdevelopersbackend.controllers;

import com.webdevelopersbackend.models.DevReport;
import com.webdevelopersbackend.services.DevReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devReport")
public class DevReportController {

    private final DevReportService devReportService;

    public DevReportController(DevReportService devReportService) {
        this.devReportService = devReportService;
    }

    @GetMapping
    public List<DevReport> getReports() {
        return this.devReportService.getReports();
    }

    @GetMapping("/{id}")
    public DevReport getReport(@PathVariable long id) {
        return this.devReportService.getReport(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteReport(@PathVariable long id) {
        DevReport report = devReportService.deleteReport(id);
        if (report == null) {
            throw new RuntimeException("Report does not exist");
        }
        return "Report was deleted.";
    }
}