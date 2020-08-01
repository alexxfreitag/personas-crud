package github.io.alexxfreitag.personascrud.domain.repository;

import github.io.alexxfreitag.personascrud.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByCpf(String cpf);
}
