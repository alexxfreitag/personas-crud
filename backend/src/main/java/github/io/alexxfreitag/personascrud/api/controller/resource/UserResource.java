package github.io.alexxfreitag.personascrud.api.controller.resource;

import github.io.alexxfreitag.personascrud.domain.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public interface UserResource {

    @GetMapping
    ResponseEntity<List<User>> getUsers();

    @GetMapping("/{id}")
    ResponseEntity<?> getUser(@PathVariable UUID id);

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody @Valid User user);

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUser(@PathVariable UUID id);

    @PutMapping("/{id}")
    ResponseEntity<?> updateUser(@PathVariable UUID id, @RequestBody @Valid User user);
}
