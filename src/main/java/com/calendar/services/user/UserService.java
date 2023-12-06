package com.calendar.services.user;

import com.calendar.dto.UserCreationDto;
import com.calendar.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    void save(UserCreationDto registrationDto);

    List<User> getAll();

    User findByEmail(String userEmail);

    void saveUser(User user);

    void delete(User user);

    boolean emailExists(String email);
}
