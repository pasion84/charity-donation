package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
