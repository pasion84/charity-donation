package pl.coderslab.charity.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.InstitutionFormDTO;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.services.InstitutionService;
import pl.coderslab.charity.services.user.UserServiceImpl;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin/organizations")
public class InstitutionController {

    private InstitutionService institutionService;
    private UserServiceImpl userService;

    //    @ModelAttribute("institutions")
//    public List<Institution> institutionList() {
//        return institutionService.getAllInstitutions();
//    }


    public InstitutionController(InstitutionService institutionService, UserServiceImpl userService) {
        this.institutionService = institutionService;
        this.userService = userService;
    }

    @GetMapping
    public String prepareInstitutionPage(Model model) {
        model.addAttribute("list", institutionService.getAllInstitutions());
        model.addAttribute("addNew", new InstitutionFormDTO());
        return "institutionListAndActions";
    }

    @PostMapping
    public String processInstitutionPage(@ModelAttribute("addNew") @Valid InstitutionFormDTO institutionFormDTO, BindingResult result) {
        institutionService.addNewInstitution(institutionFormDTO);
        return "redirect:/";
    }
}
