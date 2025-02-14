package br.sp.gov.etec.job_description.services;

import br.sp.gov.etec.job_description.model.Akv;
import br.sp.gov.etec.job_description.repository.AkvRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AkvService {

    @Autowired
    private final AkvRepository repository;

    public void saveForm(Akv akv){
        repository.save(akv);
    }

    public void viewAkv(Long id){
        repository.findById(id);
    }
}
