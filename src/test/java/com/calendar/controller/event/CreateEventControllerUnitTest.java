package com.calendar.controller.event;

import com.calendar.model.Event;
import com.calendar.model.User;
import com.calendar.services.event.EventService;
import com.calendar.services.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CreateEventControllerUnitTest {
    @Mock
    private EventService eventService;
    @InjectMocks
    private CreateEventController createEventController;
    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        createEventController = new CreateEventController(eventService, userService);
    }

    @Test
    void showCreateEventForm_UnitTest() {
        // Act
        String result = createEventController.showCreateEventForm();

        // Assert
        assertEquals("event/create-event", result);
    }

    @Test
    void createNewEvent_UnitTest_Success() {
        // Arrange
        Event event = new Event();

        // Set up a mock authentication context
        Authentication authentication = mock(Authentication.class);
        when(authentication.getName()).thenReturn("test@example.com");
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        // Mock the necessary service methods
        User currentUser = new User();
        when(userService.findByEmail("test@example.com")).thenReturn(currentUser);

        // Act
        String result = createEventController.createEvent(event);

        // Assert
        assertEquals("redirect:/", result);
        verify(userService, times(1)).saveUser(currentUser);
    }
}