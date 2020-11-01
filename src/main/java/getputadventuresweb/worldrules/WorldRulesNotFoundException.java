package getputadventuresweb.worldrules;

public class WorldRulesNotFoundException extends RuntimeException{

    WorldRulesNotFoundException(Integer id) {
        super("Could not find world rule " + id);
    }
}
