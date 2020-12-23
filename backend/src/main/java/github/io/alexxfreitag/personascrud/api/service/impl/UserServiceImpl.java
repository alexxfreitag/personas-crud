package github.io.alexxfreitag.personascrud.api.service.impl;

import github.io.alexxfreitag.personascrud.api.exception.UserAlreadyExistsException;
import github.io.alexxfreitag.personascrud.api.service.UserService;
import github.io.alexxfreitag.personascrud.domain.model.User;
import github.io.alexxfreitag.personascrud.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        Optional<User> userFounded = this.userRepository.findByCpf(user.getCpf());
        if (userFounded.isPresent()) {
            throw new UserAlreadyExistsException("A user with this CPF already exists.");
        }
        this.userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }
}
