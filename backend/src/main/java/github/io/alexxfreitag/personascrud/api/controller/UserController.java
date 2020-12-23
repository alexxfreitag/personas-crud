package github.io.alexxfreitag.personascrud.api.controller;

import github.io.alexxfreitag.personascrud.api.controller.resource.UserResource;
import github.io.alexxfreitag.personascrud.api.service.UserService;
import github.io.alexxfreitag.personascrud.domain.model.User;
import github.io.alexxfreitag.personascrud.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<User> createUser(User user) {

        User savedUser = this.userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @Override
    public ResponseEntity<User> deleteUser(UUID id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            this.userRepository.delete(user.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> updateUser(UUID id, User user) {
        return this.userRepository.findById(id).map(userData -> {
            if (!user.getCpf().isEmpty()) userData.setCpf(user.getCpf());
            if (!user.getName().isEmpty()) userData.setName(user.getName());
            if (!user.getDateOfBirth().toString().isEmpty()) userData.setDateOfBirth(user.getDateOfBirth());
            if (!user.getEmail().isEmpty()) userData.setEmail(user.getEmail());
            if (!user.getGender().isEmpty()) userData.setGender(user.getGender());
            if (!user.getNacionality().isEmpty()) userData.setNacionality(user.getNacionality());
            if (!user.getNaturality().isEmpty()) userData.setNaturality(user.getNaturality());
            this.userRepository.save(userData);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
