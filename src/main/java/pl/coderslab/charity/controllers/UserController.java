package pl.coderslab.charity.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.RegistrationFormDTO;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.services.user.UserServiceImpl;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserServiceImpl userServiceImpl;


    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @ModelAttribute("role")
    public List<Role> getAllRoles(){
        return userServiceImpl.findAllRoles();
    }

    @ModelAttribute("principalIsUser")
    public User principalToUser() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return userServiceImpl.findByEmail(principal.getName());
    }

    @GetMapping("/register")
    public String prepareRegistrationPage(Model model) {
        model.addAttribute("reg", new RegistrationFormDTO());
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistrationPage(@ModelAttribute("reg") @Valid RegistrationFormDTO data, BindingResult result) {
        if (errorsMethod(data, result)) return "registration";
        userServiceImpl.registerUser(data);
        return "redirect:/";
    }

    private boolean errorsMethod(@ModelAttribute("reg") @Valid RegistrationFormDTO data, BindingResult result) {
        if (result.hasErrors()) return true;
        if (!data.getPassword().equals(data.getRePassword())) {
            result.rejectValue("rePassword", null, "password and re password have to be match");
            return true;
        }
        if (!userServiceImpl.isEmailAvailable(data.getEmail())) {
            result.rejectValue("email", null, "email jest zajęty");
            return true;
        }
        return false;
    }

}


