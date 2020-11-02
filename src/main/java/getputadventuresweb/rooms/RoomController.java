package getputadventuresweb.rooms;

import org.springframework.web.bind.annotation.*;

@RestController
public class RoomController {

    private final RoomRespository repository;

    RoomController(RoomRespository repository) {
        this.repository = repository;
    }

    // Single item
    @CrossOrigin(origins = "*")
    @GetMapping("/room")
    RoomEntity getOne(@RequestParam Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }
}
