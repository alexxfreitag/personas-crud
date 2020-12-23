package github.io.alexxfreitag.personascrud.api.controller;

import github.io.alexxfreitag.personascrud.api.controller.resource.UserResource;
import github.io.alexxfreitag.personascrud.api.service.UserService;
import github.io.alexxfreitag.personascrud.domain.model.User;
import github.io.alexxfreitag.personascrud.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class UserController implements UserResource {

    UserRepository userRepository;
    UserService userService;

    public UserController(@Autowired UserRepository userRepository, @Autowired UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(this.userService.getUsers());
    }

    @Override
    public ResponseEntity<User> getUser(UUID id) {
        return this.userService.getUser(id);
    }

    @Override
    public ResponseEntity<User> createUser(User user) {

        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return this.userService.createUser(user);
    }

    @Override
    public ResponseEntity<User> deleteUser(UUID id) {
        return this.userService.deleteUser(id);
    }

    @Override
    public ResponseEntity<?> updateUser(UUID id, User user) {
        return this.userService.updateUser(id, user);
    }

}
