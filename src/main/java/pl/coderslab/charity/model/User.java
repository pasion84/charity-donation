package pl.coderslab.charity.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends AbstractEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true, nullable = false, name = "email")
    private String email;
    private String password;
    @Column(name = "re_password")
    private String rePassword;
    private String role;
    @Column(unique = true, nullable = false, name = "phone")
    @Pattern(regexp = "[1-9][0-9]{8}", message = "nr telefonu składa się z 9 liczb")
    private String phone;

}
