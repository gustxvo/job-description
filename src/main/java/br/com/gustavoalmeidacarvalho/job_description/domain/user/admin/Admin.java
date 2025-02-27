package br.com.gustavoalmeidacarvalho.job_description.domain.user.admin;

import br.com.gustavoalmeidacarvalho.job_description.domain.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_admins")
public class Admin extends User {

    public Admin() {
        super("ADMIN");
    }

    public Admin(String password, boolean locked, boolean enabled) {
        super(password, "ADMIN", locked, enabled);
    }

    public Admin(Integer userId, String password, boolean locked, boolean enabled) {
        super(userId, password, "ADMIN", locked, enabled);
    }

}
