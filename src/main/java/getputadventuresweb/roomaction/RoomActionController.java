package getputadventuresweb.roomaction;

import getputadventuresweb.actions.ActionEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomActionController {

    private final RoomActionRepository repository;

    RoomActionController(RoomActionRepository repository) {
        this.repository = repository;
    }

    // Action IDs for a room
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/roomaction")
    List<RoomActionEntity> getMatch(@RequestParam Integer id) {
        return repository.findByRoomId(id);
    }

    // Actions for a room
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/roomactions")
    List<ActionEntity> findActionsByRoomId(@RequestParam Integer id) {
        return repository.findActionsByRoomId(id);
    }
}

