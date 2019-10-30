package pl.coderslab.charity;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.LoggedUserDTO;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;
import pl.coderslab.charity.services.user.UserServiceImpl;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {


    private InstitutionService institutionService;
    private DonationService donationService;
    private UserServiceImpl userService;

    public HomeController(InstitutionService institutionService, DonationService donationService, UserServiceImpl userService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.userService = userService;
    }

    @ModelAttribute("principalIsUser")
    public User principalToUser() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return userService.findUser(principal.getName());
    }

    @ModelAttribute("principalIsAdmin")
    public User principalToAdmin() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return userService.findAdmin(principal.getName());
    }


    @ModelAttribute("institutions")
    public List<Institution> sumOfAllInstitutions(){
        return institutionService.getAllInstitutions();
    }
    @ModelAttribute("sumOfAllDonations")
    public Integer sumOfAllDonations(){
        return donationService.sumOfAllDonations();
    }
    @ModelAttribute("sumOfAllSupportedOrganizations")
    public Integer sumOfAllSupportedOrganizations(){
        return donationService.sumOfAllOrganizations();
    }


    @GetMapping
    public String home(Model model) {
        if (principalToUser() != null){
            model.addAttribute("loggedUser", new LoggedUserDTO(principalToUser().getFirstName()));
        }else if (principalToAdmin() != null){
            model.addAttribute("loggedAdmin", new LoggedUserDTO(principalToAdmin().getFirstName()));
        }
        return "index";
    }
}
