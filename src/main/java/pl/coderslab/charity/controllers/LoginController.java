package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.dto.LoginFormDTO;

import java.security.Principal;


@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String prepareLoginPage(Model model, Principal principal) {
        if (principal == null) {
            model.addAttribute("data", new LoginFormDTO());
            return "login";
        }
        return "redirect:/";
    }
}
