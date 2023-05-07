package com.springboot.bookshelfapp.service;

import com.springboot.bookshelfapp.model.User;
import com.springboot.bookshelfapp.repo.IUserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    User user;
    @Autowired
    @InjectMocks
    private UserService service;

    @Mock
    private IUserRepo repo;

    @BeforeEach
    public void init() {
        user = new User();
        user.setId(1L);
        user.setPassword("test");
        user.setLoginStatus(false);

    }


    @Test
    void whenValidUserIdAndPassword_thenReturnUser() {
        // stubbing
        when(repo.findUserByIdAndPassword(user.getId(), user.getPassword())).thenReturn(Optional.ofNullable(user));

        User user1 = service.getUser(1L, "test");
        assertEquals(user, user1);
        assertTrue(user1.getLoginStatus());
    }

    @Test
    void whenInValidPassword_thenReturnNull() {
        User user1 = service.getUser(1L, "not");
        assertNull(user1);
    }

    @Test
    void whenInValidUserId_thenReturnNull() {
        User user1 = service.getUser(2L, "test");
        assertNull(user1);
    }
}