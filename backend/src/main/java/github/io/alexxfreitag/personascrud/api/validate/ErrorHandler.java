package github.io.alexxfreitag.personascrud.api.validate;

import github.io.alexxfreitag.personascrud.api.exception.UserAlreadyExistsException;
import github.io.alexxfreitag.personascrud.api.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> validationException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler
    public ResponseEntity<List<String>> userAlreadyExistsException(UserAlreadyExistsException exception) {
        List<String> messages = new ArrayList<>();
        messages.add(exception.getMessage());

        return ResponseEntity.unprocessableEntity().body(messages);
    }

    @ExceptionHandler
    public ResponseEntity<List<String>> userNotFoundException(UserNotFoundException exception) {

        List<String> messages = new ArrayList<>();
        messages.add(exception.getMessage());

        return ResponseEntity.notFound().build();

    }
}
