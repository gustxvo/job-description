package br.com.gustavoalmeidacarvalho.job_description.services;

import br.com.gustavoalmeidacarvalho.job_description.model.Report;
import br.com.gustavoalmeidacarvalho.job_description.repository.ReportRepository;
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
