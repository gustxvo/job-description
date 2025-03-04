package br.com.gustavoalmeidacarvalho.jobdescription;

import br.com.gustavoalmeidacarvalho.jobdescription.app.employee.dto.AddressDto;
import br.com.gustavoalmeidacarvalho.jobdescription.app.employee.dto.EmployeeDto;
import br.com.gustavoalmeidacarvalho.jobdescription.app.mapper.EmployeeMapper;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.User;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.UserRepository;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.admin.Admin;
import br.com.gustavoalmeidacarvalho.jobdescription.domain.user.employee.EmployeeStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner dbInit(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            EmployeeMapper employeeMapper
    ) {
        return args -> {

            User user = employeeMapper.createEmployeeEntity(new EmployeeDto(
                    null,
                    "João",
                    "1231231",
                    "143",
                    "123",
                    new AddressDto("Street", "num", "complement", "city", "state", "zip"),
                    "Senior",
                    "TI",
                    "email",
                    "phoneExt",
                    BigDecimal.valueOf(5000),
                    EmployeeStatus.TERMINATED,
                    LocalDate.now().minusMonths(6),
                    LocalDate.now()
            ));
            user.setPassword("123");
            User admin = new Admin(passwordEncoder.encode("123"), false, true);

            List<User> users = Arrays.asList(user, admin);
            userRepository.saveAll(users);
        };
    }
}
