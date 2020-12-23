package github.io.alexxfreitag.personascrud.api.controller;

import github.io.alexxfreitag.personascrud.api.controller.resource.UserResource;
import github.io.alexxfreitag.personascrud.domain.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController implements UserResource {


    @Override
    public ResponseEntity<String> teste() {
        return ResponseEntity.ok("Connection sucessfuly");
    }

    @Override
    public ResponseEntity<List<User>> getUsers() {
        return null;
    }
}
