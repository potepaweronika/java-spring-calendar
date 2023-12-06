package com.calendar.controller.user;

import com.calendar.dto.UserRegistrationDto;
import com.calendar.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/registration")
public class CreateUserController {

    private final UserService userService;

    @Autowired
    public CreateUserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "user/registration";
    }

    @PostMapping
    public String registerUserAccount(@RequestBody
                                      UserRegistrationDto registrationDto) {

        userService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
