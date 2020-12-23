package github.io.alexxfreitag.personascrud.api.controller.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/source")
public interface SourceResource {

    @GetMapping
    ResponseEntity<String> getSource();
}
