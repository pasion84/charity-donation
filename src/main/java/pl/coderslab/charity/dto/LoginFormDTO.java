package pl.coderslab.charity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginFormDTO {
    private String email;
    private String password;
}
