package br.com.gustavoalmeidacarvalho.jobdescription.domain.report;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReportService {

    @Autowired
    private ReportRepository repository;

    public void saveForm(Report report){
        repository.save(report);
    }

    public void viewReport(Long id){
        repository.findById(id);
    }
}
