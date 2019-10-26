package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.services.InstitutionService;


@Controller
public class HomeController {


    private InstitutionService institutionService;

    public HomeController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("institutions", institutionService.getAllInstitutions());
        return "index";
    }
}
