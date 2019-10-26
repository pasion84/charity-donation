package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.services.InstitutionService;


@Controller
public class HomeController {


    private InstitutionService institutionService;
    private DonationRepository donationRepository;

    public HomeController(InstitutionService institutionService, DonationRepository donationRepository) {
        this.institutionService = institutionService;
        this.donationRepository = donationRepository;
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("institutions", institutionService.getAllInstitutions());
        model.addAttribute("sumOfAllDonations", donationRepository.sumOfAllDonations());
        model.addAttribute("sumOfAllSupportedOrganizations", donationRepository.sumOfAllSupportedOrganizations());
        return "index";
    }
}
