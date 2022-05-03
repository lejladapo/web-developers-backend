package com.webdevelopersbackend.services;


import com.webdevelopersbackend.models.DevReport;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class DevReportService {
    private List<DevReport> listDevReport = new ArrayList<>();

    public DevReportService() {
        listDevReport.add(testReport());
    }

    private DevReport testReport() {
        DevReport devReport = new DevReport();
        devReport.setId(1);
        devReport.setName("Ismar");
        devReport.setSurname("Becirspahic");
        devReport.setLocation("Germany");
        devReport.setNumberOfProjectsCompleted(3);
        devReport.setRecentCompletedProject("Something");
        devReport.setYearsOfExperience(1);
        devReport.setNoOfTimesDevAppliedForPosition(3);
        devReport.setNoOfTimesDevGotThePosition(3);
        devReport.setEarnings(1500);
        return devReport;
    }


    public DevReport getReport(long id) {
        for(DevReport report:listDevReport) {
            if(report.getId() == id) {
                return report;
            }
        }
        throw new RuntimeException("Report does not exist");
    }
    public List<DevReport> getReports() {
        return listDevReport;
    }

    public DevReport deleteReport(long id) {
        Iterator<DevReport> iterator = listDevReport.iterator();
        while(iterator.hasNext()) {
            DevReport report = iterator.next();
            if(report.getId() == id) {
                iterator.remove();
                return report;
            }
        }
        return null;
    }
}
