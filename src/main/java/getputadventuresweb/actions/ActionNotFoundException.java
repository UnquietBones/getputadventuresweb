package getputadventuresweb.actions;

public class ActionNotFoundException extends RuntimeException{
    public ActionNotFoundException(Integer id) {
        super("Could not find action " + id);
    }
}
