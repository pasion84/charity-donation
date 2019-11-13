package pl.coderslab.charity.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.EditUserFormDTO;
import pl.coderslab.charity.dto.RegistrationFormDTO;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.services.user.UserServiceImpl;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/user/edit")
public class EditUserController {
    private UserServiceImpl userServiceImpl;

    @ModelAttribute("principalIsUser")
    public User principalToUser() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return userServiceImpl.findByEmail(principal.getName());
    }


    public EditUserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public String prepareRegistrationPage(Model model) {
        model.addAttribute("editFormDTO", principalToUser());
        return "editUser";
    }
    @PostMapping
    public String processEditUser(@ModelAttribute("editFormDTO") @Valid EditUserFormDTO data, BindingResult result){
        if (errorsMethod(data, result)) return "editUser";
        userServiceImpl.editUser(data);
        return "redirect:/";
    }

    private boolean errorsMethod(@ModelAttribute("editFormDTO") @Valid EditUserFormDTO data, BindingResult result) {
        if (result.hasErrors()) return true;
        if (!data.getPassword().equals(data.getRePassword())) {
            result.rejectValue("rePassword", null, "password and re password have to be match");
            return true;
        }
        return false;
    }

}
