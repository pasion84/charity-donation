package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.dto.InstitutionFormDTO;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repositories.InstitutionRepository;

import java.util.List;

@Service
@Transactional
public class InstitutionService {
    private InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> getAllInstitutions() {
        return institutionRepository.findAll();
    }

    public void addNewInstitution(InstitutionFormDTO data){
        Institution institution = new Institution();
        institution.setName(data.getName());
        institution.setDescription(data.getDescription());
        institutionRepository.save(institution);
    }
}
