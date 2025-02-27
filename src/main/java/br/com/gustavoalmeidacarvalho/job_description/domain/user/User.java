package br.com.gustavoalmeidacarvalho.job_description.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Setter
@Getter
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "user_id", nullable = false, length = 8)
    private Integer userId;

    @Column(nullable = false)
    private String password;

    @Column(name = "role", nullable = false, length = 25)
    private String role;

    @Column(nullable = false)
    private boolean locked;

    @Column(nullable = false)
    private boolean enabled;

    public User(String role) {
        this.role = role;
    }

    public User(String password, String role, boolean locked, boolean enabled) {
        this.password = password;
        this.role = role;
        this.enabled = enabled;
        this.locked = locked;
    }

    public User(int userId, String password, String role, boolean locked, boolean enabled) {
        this.userId = userId;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
        this.locked = locked;
    }

    public String getUserId() {
        return String.format("%07d", userId);
    }

}
