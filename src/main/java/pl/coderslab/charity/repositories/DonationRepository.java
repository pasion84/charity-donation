package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Query(value = "select sum(quantity) from donation;", nativeQuery = true)
    Integer sumOfAllDonations();

    @Query(value = "select count(*) from (select institution_id from donation group by institution_id) as institutions;", nativeQuery = true)
    Integer sumOfAllSupportedOrganizations();
}
