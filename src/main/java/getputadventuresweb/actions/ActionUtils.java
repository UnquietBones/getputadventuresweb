package getputadventuresweb.actions;

import getputadventuresweb.roomaction.RoomActionEntity;
import getputadventuresweb.roomaction.RoomActionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ActionUtils {

    @Autowired
    RoomActionRepository roomActionRepository;

    public String doCommand(String commandList) {

        // Basic possible commands
        // -----------------------------
        // Add Item to Room                addRoomItem~[Item]~[Room]
        // Remove Item from Room           removeRoomItem~[Item]~[Room]
        // Add Action to Room              addRoomAction~[Action]~[Room]
        // Remove Action from Room         removeRoomAction~[Action]~[Room]

        // Add Item to Inventory           addPlayerItem~[Item]
        // Remove Item from Inventory      removePlayerItem~[Item]

        // Add Action to Item              addItemAction~[Item]~[Action]
        // Remove Action from Item         removeItemAction~[Item]

        // Move Player to Room             movePlayer~[Room]

        // Print Action Description        printDescription~[Action]

        // Chained commands
        // -----------------------------
        // Consume an Item to add an Exit to a room                      removePlayerItem~FDK^addExit~FD~HOR1
        // Create Item in inventory and remove action from first item    addPlayerItem~JM^removeItemAction~SL

        String[] itemCmds;
        int maxActions;
        String roomID = "";

        itemCmds = commandList.split("^");
        maxActions = itemCmds.length;

        // Time to step through the commands

        for (int actionPos = 0; actionPos < maxActions; actionPos++) {
            roomID = doSubCommand(itemCmds[actionPos]);
        }

        return roomID;
    }

    public String doSubCommand(String command) {
        String roomID = "";
        String[] itemCmds;
        itemCmds = command.split("~");

        switch (itemCmds[0]) {
            case "movePlayer":
                roomID = doMovePlayer(itemCmds);
        }

        return roomID;
    }

    public String doMovePlayer(String[] itemCmds) {
        // movePlayer~[Room]
        String roomID = "";
        roomID = itemCmds[1];
        return roomID;
    }

    public void resetAction(ActionEntity actionEntity) {
        // This is used to reset the action to it's original position
        // Overwrite current room_actions link with with a link to original room
        roomActionRepository.resetActionRoom(actionEntity.getResetRoomId(), actionEntity.getId());
    }
}
