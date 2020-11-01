package getputadventuresweb.worldrules;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WorldRulesController {

    private final WorldRulesRepository repository;

    WorldRulesController(WorldRulesRepository repository) {
        this.repository = repository;
    }

    // Single item
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/worldrules")
    WorldRulesEntity getOne(@RequestParam Integer id) {

        WorldRulesEntity foundThis = repository.findById(id).orElseThrow(() -> new WorldRulesNotFoundException(id));

        return foundThis;
    }
}
