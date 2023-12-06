package com.calendar.controller.user;

import com.calendar.dto.UserRegistrationDto;
import com.calendar.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
class RegistrationControllerIntegrationTest {
    @Mock
    private UserRepository userRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @BeforeEach
    @AfterEach
    void cleanUp() {
        userRepository.deleteAll();
    }

    @Test
    void showCreateUserForm() throws Exception {
        // Act and Assert
        mockMvc.perform(get("/registration"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("user/registration"));
    }

    // TODO: Add POST test
    @Test
    void createNewUser_Success() throws Exception {
        // Arrange
        UserRegistrationDto registrationDto = new UserRegistrationDto();
        registrationDto.setFirstName("John");
        registrationDto.setLastName("Doe");
        registrationDto.setEmail("john.doe" + System.currentTimeMillis() + "@example.com");
        registrationDto.setPassword("password");

        // Act and Assert
        mockMvc.perform(post("/registration")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(registrationDto)))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/registration?success"));

    }
}