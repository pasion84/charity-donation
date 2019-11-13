package pl.coderslab.charity.services.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.dto.EditUserFormDTO;
import pl.coderslab.charity.dto.RegistrationFormDTO;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repositories.RoleRepository;
import pl.coderslab.charity.repositories.UserRepository;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isEmailAvailable(String email) {
        Long count = userRepository.countByEmail(email);
        return count <= 0;
    }

    public List<Role>findAllRoles(){
        return roleRepository.findAll();
    }

    public void registerUser(RegistrationFormDTO data) {
        User user = new User();
        Role userRole = roleRepository.findByName("ROLE_USER");
        String encodedPassword = passwordEncoder.encode(data.getPassword());
        String encodedRePassword = passwordEncoder.encode(data.getRePassword());
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        user.setEmail(data.getEmail());
        user.setPassword(encodedPassword);
        user.setRePassword(encodedRePassword);
        user.setPhone(data.getPhone());
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    public void editUser(EditUserFormDTO data){
        User user = userRepository.findByEmail(data.getEmail());
        String encodedPassword = passwordEncoder.encode(data.getPassword());
        String encodedRePassword = passwordEncoder.encode(data.getRePassword());
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        user.setEmail(data.getEmail());
        user.setPassword(encodedPassword);
        user.setRePassword(encodedRePassword);
        user.setPhone(data.getPhone());
        userRepository.save(user);
    }
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
