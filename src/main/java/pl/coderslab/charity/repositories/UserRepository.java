package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Long countByEmail(String email);

    User findByEmail(String email);
    User findByFirstName(String firstName);

//    @Query(value = "select * from users as u inner join users_roles as ur on(u.id=ur.user_id) where ur.roles_id = 2 and u.email = ?", nativeQuery = true)
//    User findUser(String email);
//
//    @Query(value = "select * from users as u inner join users_roles as ur on(u.id=ur.user_id) where ur.roles_id = 1 and u.email = ?", nativeQuery = true)
//    User findAdmin(String email);

}
