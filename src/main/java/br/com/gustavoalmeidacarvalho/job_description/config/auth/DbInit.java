package br.com.gustavoalmeidacarvalho.job_description.config.auth;

import br.com.gustavoalmeidacarvalho.job_description.domain.user.User;
import br.com.gustavoalmeidacarvalho.job_description.domain.user.UserRepository;
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

        User user = new User("0000000", passwordEncoder.encode("123"), "ADMIN", true, false);
        User admin = new User("1111111", passwordEncoder.encode("123"), "ADMIN", true, false);

        List<User> users = Arrays.asList(user, admin);
        this.userRepository.saveAll(users);
	}

}
