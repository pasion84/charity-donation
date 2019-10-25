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
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.services.CategoryService;
import pl.coderslab.charity.services.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {
    private CategoryService categoryService;
    private CategoryRepository categoryRepository;
    private InstitutionService institutionService;

    public DonationController(CategoryService categoryService, CategoryRepository categoryRepository, InstitutionService institutionService) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
        this.institutionService = institutionService;
    }

    @ModelAttribute("categories")
    public List<Category> categoryList() {
        return categoryRepository.findAll();
    }

    @GetMapping("/addDonation")
    public String prepareAddDonation(Model model) {
        model.addAttribute("newDonation", new DonationFormDTO());
        return "newDonation";
    }
//    todo: obsługa błędów

    @PostMapping("/addDonation")
    public String processAddDonation(@ModelAttribute("newDonation") @Valid DonationFormDTO donationFormDTO, BindingResult bindingResult) {

        return "redirect:/";
    }
}
