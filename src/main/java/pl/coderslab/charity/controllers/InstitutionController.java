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

    @GetMapping("add")
    public String prepareAddInstitution(Model model){
            model.addAttribute("institutionFormDTO", new InstitutionFormDTO());
        return "createInstitution";
    }
    @PostMapping("add")
    public String processAddInstitution(@ModelAttribute("institutionFormDTO") @Valid InstitutionFormDTO institutionFormDTO, BindingResult result){
            institutionService.addNewInstitution(institutionFormDTO);
        return "redirect:/admin/organizations";
    }
    @GetMapping("edit")
    public String prepareEditInstitution(Long id, Model model){
        model.addAttribute("editInstitutionFormDTO", institutionService.getInstitutionById(id));
        return "editInstitution";
    }
    @PostMapping("edit")
    public String processEditInstitution(@ModelAttribute("editInstitutionFormDTO") @Valid InstitutionFormDTO data, BindingResult bindingResult,
                                         Long id){
        institutionService.editInstitution(data, id);
        return "redirect:/admin/organizations";
    }
    @GetMapping("delete")
    public String prepareDeleteInstitution(Long id, Model model){
        model.addAttribute("deleteInstitutionFormDTO", institutionService.getInstitutionById(id));
        return "deleteInstitution";
    }
    @GetMapping("deleteInstitution")
    public String processDeleteInstitution(Long id){
        institutionService.deleteInstitution(id);
        return "redirect:/admin/organizations";
    }

}
