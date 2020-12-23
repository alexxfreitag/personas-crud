package github.io.alexxfreitag.personascrud.api.service;

import github.io.alexxfreitag.personascrud.api.exception.UserAlreadyExistsException;
import github.io.alexxfreitag.personascrud.domain.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user) throws UserAlreadyExistsException;
    List<User> getUsers();
}
