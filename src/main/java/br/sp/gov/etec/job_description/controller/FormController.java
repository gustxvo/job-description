package br.sp.gov.etec.job_description.controller;

import br.sp.gov.etec.job_description.model.Akv;
import br.sp.gov.etec.job_description.repository.AkvRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class FormController {

    @Autowired
    AkvRepository repository;

    @GetMapping("/controleforms")
    public ModelAndView formsControl() {
        ModelAndView view = new ModelAndView("controleforms");
        List<Akv> forms = (List<Akv>) repository.findAll();
        view.addObject("forms", forms);
        return view;
    }

    @GetMapping("/visualizar/{id}")
    public String editarAluno(@PathVariable Long id, Model model) {
        Akv akv = repository.findById(id).get();
        model.addAttribute("akv", akv);
        return "visualizar";

    }

}
