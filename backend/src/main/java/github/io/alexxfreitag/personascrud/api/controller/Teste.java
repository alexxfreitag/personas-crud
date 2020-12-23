package github.io.alexxfreitag.personascrud.api.controller;

import github.io.alexxfreitag.personascrud.api.exception.UserAlreadyExistsException;
import github.io.alexxfreitag.personascrud.api.payload.SignUpRequest;
import github.io.alexxfreitag.personascrud.domain.model.User;
import github.io.alexxfreitag.personascrud.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/teste")
public class Teste {

    @PostMapping
    public ResponseEntity<?> createUser2(@Valid @RequestBody SignUpRequest signUpRequest) {

        return ResponseEntity.ok().build();
    }
}
