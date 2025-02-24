package br.com.gustavoalmeidacarvalho.job_description.domain.user;

import br.com.gustavoalmeidacarvalho.job_description.config.auth.AppUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(userId);

        if (user == null){
            throw new UsernameNotFoundException("Número da chapa ou senha inválidos");
        }

        return new AppUserDetails(user);
    }
}
