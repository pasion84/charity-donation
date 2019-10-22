package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.dto.DonationFormDTO;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repositories.DonationRepository;

@Service
@Transactional
public class DonationService {
    private DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public void addNewDonation(DonationFormDTO dto) {
        Donation donation = new Donation();
    }
}
