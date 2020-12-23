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
    List<User> getUsers();

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody @Valid User user);

    @DeleteMapping("/{id}")
    ResponseEntity<User> deleteUser(@PathVariable UUID id);
}
