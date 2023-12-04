package com.calendar.controller.user;

import com.calendar.dto.UserRegistrationDto;
import com.calendar.services.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class RegistrationControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private RegistrationController registrationController;

    @BeforeEach
    void setUp() {
        // Initialize mocks and inject them into the controller
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void showRegistrationForm() {
        // Act
        String result = registrationController.showRegistrationForm();

        // Assert
        assertEquals("user/registration", result);
    }

    @Test
    void registerUserAccount_Success() {
        // Arrange
        UserRegistrationDto registrationDto = new UserRegistrationDto();

        // Act
        String result = registrationController.registerUserAccount(registrationDto);

        // Assert
        assertEquals("redirect:/registration?success", result);
        verify(userService, times(1)).save(registrationDto);
    }
}