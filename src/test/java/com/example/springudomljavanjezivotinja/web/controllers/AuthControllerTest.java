package com.example.springudomljavanjezivotinja.web.controllers;

import com.example.springudomljavanjezivotinja.model.User;
import com.example.springudomljavanjezivotinja.respositories.UserRepository;
import com.example.springudomljavanjezivotinja.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    MockMvc mockMvc;

    @Mock
    UserService userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    public void setup() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix("/jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(new AuthController(userService))
                .setViewResolvers(viewResolver)
                .build();
    }
    @Test
    void loginPage() throws Exception {
        this.mockMvc
                .perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }
//    @Test
//    void loginUser() throws Exception {
//
//        SecurityMockMvcRequestBuilders.FormLoginRequestBuilder login = formLogin()
//                .user("userfirst@gmail.com")
//                .password("$2a$10$tTtoHWM9jQfgfbyl2UWaWuQIwYLQOIqV7/l5SO2WCZrr/tQTQYkfi");
//
//        mockMvc.perform(login)
//                .andExpect(authenticated().withUsername("userfirst@gmail.com"));
//    }

    @Test
    public void loginWithInvalidUserThenUnauthenticated() throws Exception {
        SecurityMockMvcRequestBuilders.FormLoginRequestBuilder login = formLogin()
                .user("invalid")
                .password("invalidpassword");

        mockMvc.perform(login)
                .andExpect(unauthenticated());
    }
    @Test
    void registrationPage() throws Exception {
        this.mockMvc
                .perform(get("/registration"))
                .andExpect(status().isOk())
                .andExpect(view().name("registration"))
                .andExpect(model().attributeExists("user"));
    }

//    @Test
//    void registrationUser() throws Exception {
//        User user = new User();
//
//        when(userService.save(any())).thenReturn(user);
//
//        mockMvc.perform(post("/registration")
//                .param("suc m", "")
//                .param("", "")
//        )
//                .andExpect(status().isOk())
//                .andExpect(model().attributeExists("user"))
//                .andExpect(view().name("registration"));
//
//
//
//    }
}