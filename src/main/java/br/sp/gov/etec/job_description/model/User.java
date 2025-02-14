package br.sp.gov.etec.job_description.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@SuppressWarnings("LombokDataInspection")
@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, length = 8)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(name = "role", nullable = false, length = 25)
    private String role;

    @Column(nullable = false)
    private boolean locked;

    @Column(nullable = false)
    private boolean enabled;

    public User(String userId, String password, String role, boolean locked, boolean enabled) {
        super();
        this.userId = userId;
        this.password = password;
        this.role = role;
        this.enabled = locked;
        this.locked = enabled;
    }

}
