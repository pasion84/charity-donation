package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.dto.RegistrationFormDTO;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repositories.UserRepository;

@Service
@Transactional
public class RegistrationService {

    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;

    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isEmailAvailable(String email) {
        Long count = userRepository.countByEmail(email);
        return count <= 0;
    }

    public void registerUser(RegistrationFormDTO data) {
        User user = new User();
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        user.setEmail(data.getEmail());
        user.setPassword(data.getPassword());
//        todo rePassword
        user.setPhone(data.getPhone());
        user.setRole(data.getRole());
        userRepository.save(user);
    }

}
