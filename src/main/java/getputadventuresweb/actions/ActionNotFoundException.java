package getputadventuresweb.actions;

public class ActionNotFoundException extends RuntimeException{
    ActionNotFoundException(Integer id) {
        super("Could not find action " + id);
    }
}
