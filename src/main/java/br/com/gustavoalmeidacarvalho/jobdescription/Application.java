package br.com.gustavoalmeidacarvalho.jobdescription;

import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.User;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.UserRepository;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.admin.Admin;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner dbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            User user = new Employee(passwordEncoder.encode("123"), false, true, "e", "s", "4", "1");
            User admin = new Admin(passwordEncoder.encode("123"), false, true);

            List<User> users = Arrays.asList(user, admin);
            userRepository.saveAll(users);
        };
    }
}
