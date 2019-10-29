package pl.coderslab.charity.dto;

import lombok.Data;

@Data
public class LoggedUserDTO {
    private String email;
    private String firstName;
    private String lastName;

    public LoggedUserDTO(String email) {
        this.email = email;
    }
}
