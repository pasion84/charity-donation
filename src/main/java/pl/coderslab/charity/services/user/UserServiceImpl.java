package pl.coderslab.charity.services.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
public class UserServiceImpl{

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

    public User findUser(String email){
        return userRepository.findUser(email);
    }

    public User findAdmin(String email){
        return userRepository.findAdmin(email);
    }

    public List<Role>findAllRoles(){
        return roleRepository.findAll();
    }

    public void registerUser(RegistrationFormDTO data) {
        User user = new User();
        Role userRole = roleRepository.findByName("ROLE_USER");
        saveUser(data, user);
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    public void editUser(RegistrationFormDTO data){
        User user = userRepository.findUser(data.getEmail());
        saveUser(data, user);
        userRepository.save(user);

    }

    private void saveUser(RegistrationFormDTO data, User user) {
        String encodedPassword = passwordEncoder.encode(data.getPassword());
        String encodedRePassword = passwordEncoder.encode(data.getRePassword());
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        user.setEmail(data.getEmail());
        user.setPassword(encodedPassword);
        user.setPassword(encodedRePassword);
        user.setPhone(data.getPhone());
    }
//    @Override
//    public User findByEmail(String email) {
//        return null;
//    }
//
//    @Override
//    public void saveUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        Role userRole = roleRepository.findByName("ROLE_USER");
//        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
//        userRepository.save(user);
//    }
}
