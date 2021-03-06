package github.io.alexxfreitag.personascrud.api.service;

import github.io.alexxfreitag.personascrud.api.exception.UserAlreadyExistsException;
import github.io.alexxfreitag.personascrud.domain.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    User saveUser(User user);
    ResponseEntity<User> createUser(User user) throws UserAlreadyExistsException;
    ResponseEntity<User> updateUser(UUID id, User user) throws UserAlreadyExistsException;
    ResponseEntity<User> deleteUser(UUID id);
    List<User> getUsers();
    ResponseEntity<User> getUser(UUID id);
}
