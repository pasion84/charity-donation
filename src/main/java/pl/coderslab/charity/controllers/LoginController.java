package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.LoginFormDTO;


@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String prepareLoginPage(Model model) {
        model.addAttribute("data", new LoginFormDTO());
        return "login";
    }

}
