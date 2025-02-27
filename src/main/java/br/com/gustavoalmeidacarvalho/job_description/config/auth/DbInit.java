package br.com.gustavoalmeidacarvalho.job_description.config.auth;

import br.com.gustavoalmeidacarvalho.job_description.domain.user.admin.Admin;
import br.com.gustavoalmeidacarvalho.job_description.domain.user.User;
import br.com.gustavoalmeidacarvalho.job_description.domain.user.UserRepository;
import br.com.gustavoalmeidacarvalho.job_description.domain.user.employee.Employee;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class DbInit implements CommandLineRunner{

    @Autowired
	private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args){

        User user = new Employee(passwordEncoder.encode("123"),  false, true, "e", "s", "4", "1");
        User admin = new Admin(passwordEncoder.encode("123"), false, true);

        List<User> users = Arrays.asList(user, admin);
        this.userRepository.saveAll(users);
	}

}
