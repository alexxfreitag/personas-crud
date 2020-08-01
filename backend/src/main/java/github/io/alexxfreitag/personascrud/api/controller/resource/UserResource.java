package github.io.alexxfreitag.personascrud.api.controller.resource;

import github.io.alexxfreitag.personascrud.domain.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public interface UserResource {

    @GetMapping("/test")
    ResponseEntity<String> teste();

    @GetMapping
    ResponseEntity<List<User>> getUsers();
}
