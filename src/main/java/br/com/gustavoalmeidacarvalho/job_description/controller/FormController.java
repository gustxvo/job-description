package br.com.gustavoalmeidacarvalho.job_description.controller;

import br.com.gustavoalmeidacarvalho.job_description.model.Report;
import br.com.gustavoalmeidacarvalho.job_description.repository.ReportRepository;
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
    ReportRepository repository;

    @GetMapping("/controleforms")
    public ModelAndView formsControl() {
        ModelAndView view = new ModelAndView("controleforms");
        List<Report> forms = (List<Report>) repository.findAll();
        view.addObject("forms", forms);
        return view;
    }

    @GetMapping("/visualizar/{id}")
    public String editarAluno(@PathVariable Long id, Model model) {
        Report report = repository.findById(id).get();
        model.addAttribute("akv", report);
        return "visualizar";

    }

}
