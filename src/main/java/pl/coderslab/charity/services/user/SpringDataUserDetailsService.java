//package pl.coderslab.charity.services.user;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import pl.coderslab.charity.model.User;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class SpringDataUserDetailsService implements UserDetailsService {
//
//    private UserService userService;
//
//    @Autowired
//    public void setUserRepository(UserService userService) {
//        this.userService = userService;
//    }
//
//    public UserDetails loadUserByUsername(String email){
//        User user = userService.findByEmail(email);
//        if (user == null) {
//            throw new UsernameNotFoundException(email);
//        }
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        user.getRoles().forEach(role ->
//                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName())));
//        return new CurrentUser(user.getEmail(),
//                user.getPassword(),
//                grantedAuthorities,
//                user);
//    }
//}
