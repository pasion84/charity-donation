package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.dto.DonationFormDTO;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.repositories.DonationRepository;

@Service
@Transactional
public class DonationService {
    private DonationRepository donationRepository;
    private CategoryRepository categoryRepository;
    private InstitutionService institutionService;

    public DonationService(DonationRepository donationRepository, CategoryRepository categoryRepository, InstitutionService institutionService) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionService = institutionService;
    }

    public void addNewDonation(DonationFormDTO dto) {
        Donation donation = new Donation();
        donation.setCategories(dto.getCategories());
        donation.setInstitutions(dto.getInstitutions());
        donation.setQuantity(dto.getQuantity());
        donation.setStreet(dto.getStreet());
        donation.setZipCode(dto.getZipCode());
        donation.setCity(dto.getCity());
        donation.setPickUpDate(dto.getPickUpDate());
        donation.setPickUpTime(dto.getPickUpTime());
        donation.setPickUpComment(dto.getPickUpComment());
        donationRepository.save(donation);
    }
}
