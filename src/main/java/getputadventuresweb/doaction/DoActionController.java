package getputadventuresweb.doaction;

import getputadventuresweb.actions.ActionEntity;
import getputadventuresweb.actions.ActionNotFoundException;
import getputadventuresweb.actions.ActionRepository;
import getputadventuresweb.actions.ActionResponse;
import getputadventuresweb.rooms.RoomRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoActionController {

    @Autowired
    ActionRepository actionRepository;

    @Autowired
    RoomRespository roomRespository;

    // Do an Action
    @CrossOrigin(origins = "*")
    @GetMapping("/doaction")
    ActionResponse doThisAction(@RequestParam Integer id) {
        ActionEntity actionEntity = actionRepository.findById(id)
                .orElseThrow(() -> new ActionNotFoundException(id));
        ActionResponse actionResponse = doCommand(actionEntity.getCommand());

        return actionResponse;
    }

    public ActionResponse doCommand(String commandList) {

        // Possible Commands
        // -----------------------------
        // Move Player to Room          movePlayer~[Room]
        // Add Item to Inventory        addInventory~[Action]
        // Remove Item from Inventory   dropInventory~[Action]

        // Chained commands
        // Inventory modifications should come before room moves since what displays in the room will depend
        // on what's in the inventory.
        // -----------------------------
        // Add Item to Inventory and Move Player to Room    addInventory~123^movePlayer~456

        String[] itemCmds;
        ActionResponse actionResponse = new ActionResponse();

        itemCmds = commandList.split("\\^");

        // Time to step through the commands

        for (String itemCmd : itemCmds) {
            doSubCommand(itemCmd, actionResponse);
        }

        return actionResponse;
    }

    public void doSubCommand(String command, ActionResponse actionResponse) {
        String[] itemCmds;
        itemCmds = command.split("~");

        switch (itemCmds[0]) {
            case "movePlayer":
                actionResponse.setNewRoom(Integer.parseInt(itemCmds[1]));
                break;
            case "addInventory":
                ActionEntity newAction = actionRepository.findById(Integer.parseInt(itemCmds[1])).orElse(null);
                actionResponse.setAddAction(newAction);
                break;
            case "dropInventory":
                actionResponse.setDropAction(Integer.parseInt(itemCmds[1]));
                break;
        }
    }
}
