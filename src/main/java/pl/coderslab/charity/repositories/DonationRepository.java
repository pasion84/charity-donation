package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Query(value = "select sum(quantity) from donations;", nativeQuery = true)
    Integer sumOfAllDonations();

    @Query(value = "select count(*) from (select institutions_id from donations group by institutions_id) as institutions;", nativeQuery = true)
    Integer sumOfAllSupportedOrganizations();
}
