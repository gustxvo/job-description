package br.com.gustavoalmeidacarvalho.jobdescription.app.department;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class OrgChartController {

    @GetMapping("/organograma")
    public String organizationChart() {
        return "admin/organograma";
    }
}
