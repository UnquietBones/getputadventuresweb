package getputadventuresweb.rooms;

public class RoomNotFoundException extends RuntimeException{

    RoomNotFoundException(Integer id) {
        super("Could not find room " + id);
    }
}
