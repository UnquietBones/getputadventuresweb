package getputadventuresweb.actions;

public class ActionResponse {
    Integer newRoom;            // New room location
    ActionEntity addAction;     // Action to add to inventory
    Integer dropAction;         // Action to remove from inventory

    public Integer getNewRoom() {
        return newRoom;
    }

    public void setNewRoom(Integer newRoom) {
        this.newRoom = newRoom;
    }

    public ActionEntity getAddAction() {
        return addAction;
    }

    public void setAddAction(ActionEntity addAction) {
        this.addAction = addAction;
    }

    public Integer getDropAction() {
        return dropAction;
    }

    public void setDropAction(Integer dropAction) {
        this.dropAction = dropAction;
    }
}
