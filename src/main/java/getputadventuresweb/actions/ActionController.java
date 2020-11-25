package getputadventuresweb.actions;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActionController {

    private final ActionRepository repository;

    ActionController(ActionRepository repository) {
        this.repository = repository;
    }

    // Single item
    @CrossOrigin(origins = "*")
    @GetMapping("/action")
    ActionEntity getAction(@RequestParam Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ActionNotFoundException(id));
    }
}
