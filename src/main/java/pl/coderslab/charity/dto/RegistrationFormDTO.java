package pl.coderslab.charity.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class RegistrationFormDTO {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String role;
    @NotBlank
    @Pattern(regexp = "[1-9][0-9]{8}", message = "nr telefonu składa się z 9 liczb")
    private String phone;

}
