package br.com.gustavoalmeidacarvalho.jobdescription.app.department;

import br.com.gustavoalmeidacarvalho.jobdescription.domain.department.FormService;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.Report;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.report.ReportService;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class JobController {

	@Autowired
	private EmployeeRepository repository;

	@Autowired
	private ReportService reportService;

	@Autowired
	private FormService formService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/organograma")
	public String organogrma() {
		return "organograma";
	}

	@GetMapping("/cadastrofunc")
	public String cadastrofunc() {
		return "cadastrofunc";
	}

	@GetMapping("/report")
	public String akv(Model model, @Param("user_id") Principal principal) {
//		String employee_id = principal.getName();
//		String ou = repository.findDepartmentByEmployee(employee_id);
//		String area = repository.findOuArea(employee_id);
//		String acronym = repository.findOuAcronym(employee_id);
//		String nameEn = repository.findOuNameEn(employee_id);
//		String namePtBr = repository.findOuNamePtBr(employee_id);
		model.addAttribute("area", "area");
		model.addAttribute("acronym", "acronym");
		model.addAttribute("name_en", "nameEn");
		model.addAttribute("name_pt_br", "namePtBr");
		model.addAttribute("ou", "ou");
		return "report";
	}

	@PostMapping("/salvar")
	public String Salvar(Report report) {
		reportService.saveForm(report);
		return 	"redirect:/report";
	}

	@GetMapping("/arquivamento")
	public String listDepartments(Model model, @Param("keyword") String keyword){

		if (keyword != null){
			model.addAttribute("departments", formService.searchDepartment(keyword));
		} else {
			model.addAttribute("departments", formService.listDepartment());
		}
		return "arquivamento";
	}

	@PostMapping("/voltar")
	public String voltar(){
		return "redirect:/controleforms";
	}
}
