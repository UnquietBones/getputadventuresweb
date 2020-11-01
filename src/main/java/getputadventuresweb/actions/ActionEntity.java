package getputadventuresweb.actions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "actions")
public class ActionEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "command")
    private String command;

    @Column(name = "requires_room_id")
    private Integer requiresRoomId;

    @Column(name = "requires_action_id")
    private Integer requiresActionId;

    @Column(name = "reset_room_id")
    private Integer resetRoomId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Integer getResetRoomId() {
        return resetRoomId;
    }

    public void setResetRoomId(Integer resetRoomId) {
        this.resetRoomId = resetRoomId;
    }

    public Integer getRequiresRoomId() {
        return requiresRoomId;
    }

    public void setRequiresRoomId(Integer requiresRoomId) {
        this.requiresRoomId = requiresRoomId;
    }

    public Integer getRequiresActionId() {
        return requiresActionId;
    }

    public void setRequiresActionId(Integer requiresActionId) {
        this.requiresActionId = requiresActionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionEntity that = (ActionEntity) o;
        return id.equals(that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(command, that.command) &&
                Objects.equals(requiresRoomId, that.requiresRoomId) &&
                Objects.equals(requiresActionId, that.requiresActionId) &&
                Objects.equals(resetRoomId, that.resetRoomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, command, requiresRoomId, requiresActionId, resetRoomId);
    }

    @Override
    public String toString() {
        return "ActionEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", command='" + command + '\'' +
                ", requiresRoomId='" + requiresRoomId + '\'' +
                ", requiresActionId='" + requiresActionId + '\'' +
                ", resetRoomId='" + resetRoomId + '\'' +
                '}';
    }
}
