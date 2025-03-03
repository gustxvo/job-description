package br.com.gustavoalmeidacarvalho.jobdescription.app.report;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ReportController {

    @GetMapping("/controle-form")
    public String ongoingReports() {
        return "admin/controle-form";
    }

    @GetMapping("/arquivamento")
    public String reportsDone() {
        return "admin/arquivamento";
    }

}
