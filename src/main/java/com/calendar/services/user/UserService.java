package com.calendar.services.user;

import com.calendar.dto.UserRegistrationDto;
import com.calendar.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    void save(UserRegistrationDto registrationDto);

    List<User> getAll();

    User findByEmail(String userEmail);

    void saveUser(User user);

}
