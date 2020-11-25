
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

    // Actions for a room
    @CrossOrigin(origins = "*")
    @GetMapping("/roomactions")
    List<ActionEntity> findActionsByRoomId(@RequestParam Integer id, @RequestParam List<Integer> inventoryList) {

        // In case there's nothing in the inventory, we need to put something in inventoryList so
        // MySQL dosen't have kittenfits
        if (inventoryList.size() < 1) {
            inventoryList.add(777777777);
        }

        return repository.findActionsByRoomId(id, inventoryList);
    }
}

