package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.RegistrationFormDTO;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.services.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/register")
public class UserController {

    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("role")
    public List<Role> getAllRoles(){
        return userService.findAllRoles();
    }

    @GetMapping
    public String prepareRegistrationPage(Model model) {
        model.addAttribute("reg", new RegistrationFormDTO());
        return "registration";
    }

    @PostMapping
    public String processRegistrationPage(@ModelAttribute("reg") @Valid RegistrationFormDTO data, BindingResult result) {
        if (result.hasErrors()) return "registration";
        if (!data.getPassword().equals(data.getRePassword())) {
            result.rejectValue("rePassword", null, "password and re password have to be match");
            return "registration";
        }
        if (!userService.isEmailAvailable(data.getEmail())) {
            result.rejectValue("email", null, "email jest zajęty");
            return "registration";
        }
        userService.registerUser(data);
        return "redirect:/";
    }
}
