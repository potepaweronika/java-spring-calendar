package com.calendar.controller.user;

import com.calendar.dto.UserCreationDto;
import com.calendar.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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
    public UserCreationDto userCreationDto() {
        return new UserCreationDto();
    }

    @GetMapping
    public String showCreateUserForm() {
        return "user/create-user";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") UserCreationDto creationDto) {
        userService.save(creationDto);

        return "redirect:/registration?success";
    }
}
