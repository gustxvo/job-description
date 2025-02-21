package br.com.gustavoalmeidacarvalho.job_description.controller;

import br.com.gustavoalmeidacarvalho.job_description.model.Report;
import br.com.gustavoalmeidacarvalho.job_description.repository.ReportRepository;
import br.com.gustavoalmeidacarvalho.job_description.repository.DepartmentRepository;
import br.com.gustavoalmeidacarvalho.job_description.repository.EmployeeRepository;
import br.com.gustavoalmeidacarvalho.job_description.services.ReportService;
import br.com.gustavoalmeidacarvalho.job_description.services.FormService;
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
	private ReportRepository reportRepository;

	@Autowired
	private DepartmentRepository depRepository;

	@Autowired
	private ReportService reportService;

	@Autowired
	private FormService formService;

	@GetMapping("/")
	public String index() {
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/teste")
	public String teste() {
		return "teste";
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
		String employee_id = principal.getName();
		String ou = repository.findDepartmentByEmployee(employee_id);
		String area = repository.findOuArea(employee_id);
		String acronym = repository.findOuAcronym(employee_id);
		String nameEn = repository.findOuNameEn(employee_id);
		String namePtBr = repository.findOuNamePtBr(employee_id);
		model.addAttribute("area", area);
		model.addAttribute("acronym", acronym);
		model.addAttribute("name_en", nameEn);
		model.addAttribute("name_pt_br", namePtBr);
		model.addAttribute("ou", ou);
		return "report";
	}

//	@GetMapping("/controleforms")
//	public ModelAndView controleforms() {
//		ModelAndView view = new ModelAndView("controleforms");
//		List<Akv> akv = (List<Akv>) akvRepository.findAll();
////		view.addObject(new Akv());
//		view.addObject("clientes", akv);
//		return view;
//	}

	@PostMapping("/salvar")
	public String Salvar(Report report) {
		reportService.saveForm(report);
		return 	"redirect:/report";
	}

//	@GetMapping("/arquivamento")
//	public String arquivamento() {
//		return "arquivamento";
//	}

//	@GetMapping("/cliente/visualizar/{id}")
//	public String editarAluno(@PathVariable Long id, Model model) {
//		JobModelAkv jobModelAkv = repository.findById(id).get();
//		model.addAttribute(jobModelAkv);
//		return "visualizar";
//	}
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
