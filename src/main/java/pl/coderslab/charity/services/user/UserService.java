package pl.coderslab.charity.services.user;

import pl.coderslab.charity.model.User;

public interface UserService {
    User findByEmail(String email);
    void saveUser(User user);
}
