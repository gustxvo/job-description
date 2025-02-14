//package br.sp.gov.etec.job_description.auth;
//
//import br.sp.gov.etec.job_description.model.Department;
//import br.sp.gov.etec.job_description.model.Employee;
//import br.sp.gov.etec.job_description.model.User;
//import br.sp.gov.etec.job_description.repository.EmployeeRepository;
//import br.sp.gov.etec.job_description.repository.UserRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class DbInit implements CommandLineRunner{
//
//	private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;
//
//	@Override
//	public void run(String... args){
////		 Delete all
////		this.userRepository.deleteAll();
//
//        User user = new User("0000000", passwordEncoder.encode("123"), "ADMIN", false, true);
//        User admin = new User("1111111", passwordEncoder.encode("123"), "ADMIN", false, true);
//
////        User admin =new User("7654321", "Daniel", "TI");
//
//        List<User> users = Arrays.asList(user, admin);
//        this.userRepository.saveAll(users);
////		 Create users
//
//
//	}
//
//}
