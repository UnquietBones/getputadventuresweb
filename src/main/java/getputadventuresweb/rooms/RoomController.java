package getputadventuresweb.rooms;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class RoomController {

    private final RoomRespository repository;

    public RoomController(RoomRespository repository) {
        this.repository = repository;
    }

    // Single item
    @CrossOrigin(origins = "*")
    @GetMapping("/room")
    public RoomEntity getOne(@RequestParam Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }

    // All rooms
    @CrossOrigin(origins = "*")
    @GetMapping("/allrooms")
    ArrayList getAll() {
        return (ArrayList) repository.findAll();
    }
}
