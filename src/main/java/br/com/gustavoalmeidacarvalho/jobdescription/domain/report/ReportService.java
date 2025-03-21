package br.com.gustavoalmeidacarvalho.jobdescription.domain.report;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gustavoalmeidacarvalho.jobdescription.domain.department.Department;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.department.DepartmentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;
    private final DepartmentRepository departmentRepository;

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

    public Department findDepartmentByEmployeeId(Integer employeeId) {
        return departmentRepository.findDepartmentByHolder_UserId(employeeId);
    }

}
