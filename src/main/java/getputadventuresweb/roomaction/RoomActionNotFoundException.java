package getputadventuresweb.roomaction;

public class RoomActionNotFoundException extends RuntimeException{
    RoomActionNotFoundException(Integer id) {
        super("Could not find roomaction " + id);
    }
}

