package getputadventuresweb.roomaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "room_actions")
public class RoomActionEntity {

    @Id
    @Column(name = "room_id")
    private Integer roomID;

    @Column(name = "action_id")
    private Integer actionID;

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        this.roomID = roomID;
    }

    public Integer getActionID() {
        return actionID;
    }

    public void setActionID(Integer actionID) {
        this.actionID = actionID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomActionEntity that = (RoomActionEntity) o;
        return roomID.equals(that.roomID) &&
                actionID.equals(that.actionID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomID, actionID);
    }

    @Override
    public String toString() {
        return "RoomActionEntity{" +
                "roomID=" + roomID +
                ", actionID='" + actionID + '\'' +
                '}';
    }
}
