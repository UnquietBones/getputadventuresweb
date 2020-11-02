package getputadventuresweb.worldrules;

import org.springframework.web.bind.annotation.*;

@RestController
public class WorldRulesController {

    private final WorldRulesRepository repository;

    WorldRulesController(WorldRulesRepository repository) {
        this.repository = repository;
    }

    // Single item
    @CrossOrigin(origins = "*")
    @GetMapping("/worldrules")
    WorldRulesEntity getOne(@RequestParam Integer id) {

        WorldRulesEntity foundThis = repository.findById(id).orElseThrow(() -> new WorldRulesNotFoundException(id));

        return foundThis;
    }
}
