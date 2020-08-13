package github.io.alexxfreitag.personascrud.api.controller;

import github.io.alexxfreitag.personascrud.domain.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    private MockMvc mockMvc;

    @Autowired
    UserController userController;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void shouldReturnOK() throws Exception {
        this.mockMvc.perform(get("/users")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldNotCreateUserWithInvalidData() throws Exception {
        User user = new User("", "", "Masculino", "alex@email.com", LocalDate.now(), "Brazil", "SC");
        this.mockMvc.perform(post("/users")).andExpect(MockMvcResultMatchers.status().isBadRequest());

    }
}
