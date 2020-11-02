package getputadventuresweb.actions;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActionController {

    private final ActionRepository repository;

    ActionController(ActionRepository repository) {
        this.repository = repository;
    }

    // Single item
    @CrossOrigin(origins = "https://main.d2c75mp6llcf4b.amplifyapp.com/")
    @GetMapping("/action")
    ActionEntity getAction(@RequestParam Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new ActionNotFoundException(id));
    }

    // Do an Action
    @CrossOrigin(origins = "https://main.d2c75mp6llcf4b.amplifyapp.com/")
    @GetMapping("/doaction")
    String doThisAction(@RequestParam Integer id) {
        String roomID = "";
        ActionEntity actionEntity = repository.findById(id)
                .orElseThrow(() -> new ActionNotFoundException(id));
        ActionUtils actionUtils = new ActionUtils();
        roomID = actionUtils.doCommand(actionEntity.getCommand());
        return roomID;
    }

    // Reset inventory actions
    @CrossOrigin(origins = "*")
    @GetMapping("/resetinventory")
    void doThisAction(@RequestParam Integer[] ids) {
        ActionUtils actionUtils = new ActionUtils();
        for (Integer id : ids) {
            actionUtils.resetAction(getAction(id));
        }
    }
}
