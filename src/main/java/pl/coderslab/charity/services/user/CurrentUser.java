//package pl.coderslab.charity.services.user;
//
//import org.springframework.security.core.GrantedAuthority;
//
//import java.util.Collection;
//
//public class CurrentUser extends org.springframework.security.core.userdetails.User {
//    private final pl.coderslab.charity.model.User user;
//
//    public CurrentUser(String email, String password,
//                       Collection<? extends GrantedAuthority> authorities,
//                       pl.coderslab.charity.model.User user){
//        super(email, password, authorities);
//        this.user = user;
//    }
//    public pl.coderslab.charity.model.User getUser(){
//        return user;
//    }
//}
