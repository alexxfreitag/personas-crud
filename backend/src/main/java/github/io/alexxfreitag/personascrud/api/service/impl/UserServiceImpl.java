package github.io.alexxfreitag.personascrud.api.service.impl;

import github.io.alexxfreitag.personascrud.api.exception.UserAlreadyExistsException;
import github.io.alexxfreitag.personascrud.api.exception.UserNotFoundException;
import github.io.alexxfreitag.personascrud.api.service.UserService;
import github.io.alexxfreitag.personascrud.domain.model.User;
import github.io.alexxfreitag.personascrud.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_NOT_FOUND = "User not found";
    private static final String USER_ALREADY_EXISTS = "A user with this CPF already exists";

    private final UserRepository userRepository;

    public UserServiceImpl(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        this.userRepository.save(user);
        return user;
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        Optional<User> userFounded = this.userRepository.findByCpf(user.getCpf());
        if (userFounded.isPresent()) {
            throw new UserAlreadyExistsException(USER_ALREADY_EXISTS);
        }
        return ResponseEntity.ok(saveUser(user));
    }

    @Override
    public ResponseEntity<User> updateUser(UUID id, User user) {

        return this.userRepository.findById(id).map(userData -> {
            if (!user.getCpf().isEmpty()) {
                if (!user.getCpf().equals(userData.getCpf())) {
                    Optional<User> userFounded = this.userRepository.findByCpf(user.getCpf());
                    if (userFounded.isPresent()) {
                        throw new UserAlreadyExistsException(USER_ALREADY_EXISTS);
                    }
                    userData.setCpf(user.getCpf());
                }
            }
            if (!user.getName().isEmpty()) userData.setName(user.getName());
            if (!user.getDateOfBirth().toString().isEmpty()) userData.setDateOfBirth(user.getDateOfBirth());
            if (!user.getEmail().isEmpty()) userData.setEmail(user.getEmail());
            if (!user.getGender().isEmpty()) userData.setGender(user.getGender());
            if (!user.getNacionality().isEmpty()) userData.setNacionality(user.getNacionality());
            if (!user.getNaturality().isEmpty()) userData.setNaturality(user.getNaturality());
            userData.setUpdatedAt(LocalDateTime.now());
            return ResponseEntity.ok(saveUser(userData));
        }).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
    }

    @Override
    public ResponseEntity<User> deleteUser(UUID id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            this.userRepository.delete(user.get());
            return ResponseEntity.noContent().build();
        }
        throw new UserNotFoundException(USER_NOT_FOUND);
    }


    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public ResponseEntity<User> getUser(UUID id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        throw new UserNotFoundException(USER_NOT_FOUND);
    }
}
