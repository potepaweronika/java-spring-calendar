package com.calendar.controller.user;

import com.calendar.dto.UserCreationDto;
import com.calendar.model.User;
import com.calendar.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CreateUserControllerIntegrationTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private User testUser;

    @Test
    void showCreateUserForm_IntegrationTest() throws Exception {
        // Act and Assert
        mockMvc.perform(get("/registration"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("user/create-user"));
    }

    @Test
    void createNewUser_IntegrationTest_Success() throws Exception {
        // Arrange
        UserCreationDto userCreationDto = new UserCreationDto();
        userCreationDto.setFirstName("John");
        userCreationDto.setLastName("Doe");
        userCreationDto.setEmail("john.doe" + System.currentTimeMillis() + "@example.com");
        userCreationDto.setPassword("password");

        // Act and Assert
        mockMvc.perform(post("/registration")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("firstName", userCreationDto.getFirstName())
                        .param("lastName", userCreationDto.getLastName())
                        .param("email", userCreationDto.getEmail())
                        .param("password", userCreationDto.getPassword()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/registration?success"));

        // Save the created user to a variable
        testUser = userRepository.findByEmail(userCreationDto.getEmail());
    }

    @AfterEach
    void cleanUp() {
        // Delete the test user
        if (testUser != null) {
            userRepository.delete(testUser);
        }
    }
}