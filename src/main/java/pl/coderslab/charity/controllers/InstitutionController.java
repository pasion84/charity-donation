package pl.coderslab.charity.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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


    public InstitutionController(InstitutionService institutionService, UserServiceImpl userService) {
        this.institutionService = institutionService;
        this.userService = userService;
    }

    @GetMapping
    public String prepareInstitutionPage(Model model) {
        model.addAttribute("institutionList", institutionService.getAllInstitutions());
        return "institutionListAndActions";
    }

    @PostMapping
    public String processDeleteInstitution(@RequestParam Long id) {
        institutionService.deleteInstitution(id);
        return "redirect:/admin/organizations";
    }

    @GetMapping("/addOrEdit")
    public String prepareAddInstitution(Model model, Long id){
        if (id == null){
            model.addAttribute("institutionFormDTO", new InstitutionFormDTO());
        }else {
            model.addAttribute("institutionFormDTO", institutionService.getInstitutionById(id));
        }
        return "createEditInstitution";
    }
    @PostMapping("/addOrEdit")
    public String processAddInstitution(@ModelAttribute("institutionFormDTO") @Valid InstitutionFormDTO institutionFormDTO, BindingResult result, Model model, Long id){
        if (id == null){
            institutionService.addNewInstitution(institutionFormDTO);
        }else{
            institutionService.editInstitution(institutionFormDTO, id);
        }
        return "redirect:/admin/organizations";
    }
}
