package com.calendar.controller.user;

import com.calendar.dto.UserCreationDto;
import com.calendar.services.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CreateUserControllerUnitTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private CreateUserController createUserController;

    @BeforeEach
    void setUp() {
        // Initialize mocks and inject them into the controller
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void showCreateUserForm_UnitTest() {
        // Act
        String result = createUserController.showCreateUserForm();

        // Assert
        assertEquals("user/create-user", result);
    }

    @Test
    void createNewUser_UnitTest_Success() {
        // Arrange
        UserCreationDto creationDto = new UserCreationDto();

        // Act
        String result = createUserController.createUser(creationDto);

        // Assert
        assertEquals("redirect:/registration?success", result);
        verify(userService, times(1)).save(creationDto);
    }
}