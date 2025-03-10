package br.com.gustavoalmeidacarvalho.jobdescription.domain.report;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;

    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    public Report findById(Long reportId) {
        return reportRepository.findById(reportId)
                .orElseThrow(() -> new IllegalArgumentException("Report not found with id " + reportId));
    }

    public void save(Report report) {
        reportRepository.save(report);
    }

}
