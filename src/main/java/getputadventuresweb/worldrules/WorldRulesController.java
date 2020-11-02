package getputadventuresweb.worldrules;

import org.springframework.web.bind.annotation.*;

@RestController
public class WorldRulesController {

    private final WorldRulesRepository repository;

    WorldRulesController(WorldRulesRepository repository) {
        this.repository = repository;
    }

    // Single item
    @CrossOrigin(origins = "https://main.d2c75mp6llcf4b.amplifyapp.com:4200")
    @GetMapping("/worldrules")
    WorldRulesEntity getOne(@RequestParam Integer id) {

        WorldRulesEntity foundThis = repository.findById(id).orElseThrow(() -> new WorldRulesNotFoundException(id));

        return foundThis;
    }
}
