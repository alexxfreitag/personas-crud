package github.io.alexxfreitag.personascrud.api.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(final String cpf) {
        super(cpf);
    }
}
