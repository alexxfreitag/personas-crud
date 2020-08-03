package github.io.alexxfreitag.personascrud.api.controller;

import github.io.alexxfreitag.personascrud.api.controller.resource.UserResource;
import github.io.alexxfreitag.personascrud.api.service.UserService;
import github.io.alexxfreitag.personascrud.domain.model.User;
import github.io.alexxfreitag.personascrud.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class UserController implements UserResource {

    UserRepository userRepository;
    UserService userService;

    public UserController(@Autowired UserRepository userRepository, @Autowired UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public ResponseEntity<String> teste() {
        return ResponseEntity.ok("Connection sucessfuly");
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<User> createUser(User user) {

        User savedUser = this.userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

}
