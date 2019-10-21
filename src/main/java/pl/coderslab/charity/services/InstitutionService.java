package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InstitutionService {
    private InstitutionService institutionService;

    public InstitutionService(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }
}
