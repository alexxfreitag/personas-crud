package github.io.alexxfreitag.personascrud.api.controller;

import github.io.alexxfreitag.personascrud.api.service.UserService;
import github.io.alexxfreitag.personascrud.api.service.impl.UserServiceImpl;
import github.io.alexxfreitag.personascrud.domain.model.User;
import github.io.alexxfreitag.personascrud.domain.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    private static final String NAME = "Alex Freitag";
    private static final String CPF = "12345675912";
    private static final String GENDER = "Masculino";
    private static final String EMAIL = "Masculino";
    private static final String NACIONALITY = "Brazil";
    private static final String NATURALITY = "SC";

    private MockMvc mockMvc;

    @Autowired
    UserController userController;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    User user;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        userService = new UserServiceImpl(userRepository);
        user = new User(NAME, CPF, GENDER, EMAIL, LocalDate.now(), NACIONALITY, NATURALITY);
    }

    @Test
    public void shouldReturnUsers_ok() throws Exception {
        this.mockMvc.perform(get("/users")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldReturnUser_ok() throws Exception {
        User userSaved = userService.saveUser(user);
        this.mockMvc.perform(get("/users")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldNotCreateUserWithInvalidData_bad() throws Exception {
        user = new User("", "", "Masculino", "alex@email.com", LocalDate.now(), "Brazil", "SC");
        this.mockMvc.perform(post("/users")).andExpect(MockMvcResultMatchers.status().isBadRequest());

    }
}
