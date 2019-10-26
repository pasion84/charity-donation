package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.DonationFormDTO;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.repositories.InstitutionRepository;
import pl.coderslab.charity.services.CategoryService;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {
    private CategoryService categoryService;
    private CategoryRepository categoryRepository;
    private InstitutionService institutionService;
    private InstitutionRepository institutionRepository;
    private DonationService donationService;

    public DonationController(CategoryService categoryService, CategoryRepository categoryRepository, InstitutionService institutionService, InstitutionRepository institutionRepository, DonationService donationService) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
        this.institutionService = institutionService;
        this.institutionRepository = institutionRepository;
        this.donationService = donationService;
    }

    @ModelAttribute("categories")
    public List<Category> categoryList() {
        return categoryRepository.findAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutionList() {
        return institutionRepository.findAll();
    }

    @GetMapping
    public String prepareAddDonation(Model model) {
        model.addAttribute("createDonation", new DonationFormDTO());
        return "newDonation";
    }
//    todo: obsługa błędów

    @PostMapping
    public String processAddDonation(@ModelAttribute("createDonation") @Valid DonationFormDTO donationFormDTO, BindingResult bindingResult) {
        donationService.addNewDonation(donationFormDTO);
        return "redirect:/";
    }
}
