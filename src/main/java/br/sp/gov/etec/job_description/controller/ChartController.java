package br.sp.gov.etec.job_description.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("organograma/")
public class ChartController {

    @GetMapping("primeiro")
    public String primeiro() {
        return "primeiro";
    }
    @GetMapping("segundo")
    public String segundo() {
        return "segundo";
    }
    @GetMapping("terceiro")
    public String terceiro() {
        return "terceiro";
    }
    @GetMapping("quarto")
    public String quarto() {
        return "quarto";
    }
    @GetMapping("quinto")
    public String quinto() {
        return "quinto";
    }
    @GetMapping("sexto")
    public String sexto() {
        return "sexto";
    }
    @GetMapping("setimo")
    public String setimo() {
        return "setimo";
    }
}
