package com.example.springudomljavanjezivotinja.service;

import com.example.springudomljavanjezivotinja.model.User;
import com.example.springudomljavanjezivotinja.respositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    @MockBean
    UserRepository userRepository;

    User user;

    @Test
    void save() {
    }



    @Test
    void isUserEmailPresent() {
        User existEmailRepo = new User();

        userRepository.save(existEmailRepo);

        when(userRepository.findByEmail("adminprvi@gmail.com")).thenReturn(Optional.of(existEmailRepo));

        assertThat(existEmailRepo).isNotNull();

    }

    @Test
    void loadUserByUsername() {
    }
}