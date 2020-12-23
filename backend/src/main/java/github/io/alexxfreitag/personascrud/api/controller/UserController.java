package github.io.alexxfreitag.personascrud.api.controller;

import github.io.alexxfreitag.personascrud.api.controller.resource.UserResource;
import github.io.alexxfreitag.personascrud.api.exception.UserAlreadyExistsException;
import github.io.alexxfreitag.personascrud.domain.model.User;
import github.io.alexxfreitag.personascrud.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController implements UserResource {

    UserRepository userRepository;

    public UserController(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<String> teste() {
        return ResponseEntity.ok("Connection sucessfuly");
    }

    @Override
    public ResponseEntity<List<User>> getUsers() {
        return null;
    }

    @Override
    public ResponseEntity<User> createUser(User user) {

        if (userRepository.existsByCpf(user.getCpf())) {
            throw new UserAlreadyExistsException("A user with this CPF already exists.");
        }
        User userCreated = userRepository.save(user);
        return ResponseEntity.ok(userCreated);
    }


}
