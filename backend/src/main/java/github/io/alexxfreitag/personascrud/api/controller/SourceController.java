package github.io.alexxfreitag.personascrud.api.controller;

import github.io.alexxfreitag.personascrud.api.controller.resource.SourceResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class SourceController implements SourceResource {

    @Override
    public ResponseEntity<String> getSource() {
        return ResponseEntity.ok("https://github.com/alexxfreitag/personas-crud");
    }
}
