package getputadventuresweb.rooms;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class RoomController {

    private final RoomRespository repository;

    RoomController(RoomRespository repository) {
        this.repository = repository;
    }

    // Single item
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/room")
    RoomEntity getOne(@RequestParam Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }
}
