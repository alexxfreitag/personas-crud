package github.io.alexxfreitag.personascrud.api.service;

import github.io.alexxfreitag.personascrud.api.exception.UserAlreadyExistsException;
import github.io.alexxfreitag.personascrud.api.service.impl.UserServiceImpl;
import github.io.alexxfreitag.personascrud.domain.model.User;
import github.io.alexxfreitag.personascrud.domain.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({ "test" })
public class UserServiceTest {

    private static final String NOME = "Alex Freitag";
    private static final String CPF = "12345678912";

    @MockBean
    private UserRepository userRepository;

    private UserService userService;
    private User user;

    @Before
    public void setUp() throws Exception {
        userService = new UserServiceImpl(userRepository);

        user = new User(NOME, CPF, "Masculino", "alex@email.com", LocalDate.now(), "Brazil", "SC");

    }

    @Test
    public void shouldCreateAndSaveUserInRepository() throws Exception {
        userService.saveUser(user);
        verify(userRepository).save(user);
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void shouldNotCreateTwoUsersWithSameCPF() throws UserAlreadyExistsException {
        when(userRepository.findByCpf(CPF)).thenReturn(Optional.of(user));
        userService.saveUser(user);
    }
}
