package getputadventuresweb.roomaction;

import getputadventuresweb.actions.ActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomActionRepository extends JpaRepository<RoomActionEntity, Integer>, JpaSpecificationExecutor<RoomActionEntity> {

    @Query("SELECT t " +
            "FROM RoomActionEntity t " +
            "WHERE t.roomID = :roomID")
    public List<RoomActionEntity> findByRoomId(@Param("roomID") Integer roomID);

    @Query("SELECT t2 " +
            "FROM RoomActionEntity t1 " +
            "JOIN ActionEntity t2 ON t1.actionID = t2.id " +
            "WHERE t1.roomID = :roomID ")
    public List<ActionEntity> findActionsByRoomId(@Param("roomID") Integer roomID);

    @Query("SELECT t2 " +
            "FROM RoomActionEntity t1 " +
            "JOIN ActionEntity t2 ON t1.actionID = t2.id " +
            "WHERE t1.roomID = :roomID " +
            "AND ((t2.forbidsActionId IS NULL) " +
                "OR ((t2.forbidsActionId IS NOT NULL) " +               // forbidden action
                    "AND (t2.forbidsActionId NOT IN (:invList))))" +     // or not in InvList
            "AND ((t2.requiresActionId IS NULL) "+
                "OR (t2.requiresActionId IS NOT NULL "+             // required action
                    "AND (t2.requiresActionId IN (:invList))))")    // required action is in InvList
    public List<ActionEntity> findActionsByRoomId(@Param("roomID") Integer roomID, @Param("invList") List<Integer> invList);

    @Query("UPDATE RoomActionEntity t " +
            "SET t.roomID = :resetRoomId " +
            "WHERE t.actionID = :actionID")
    public void resetActionRoom(@Param("actionID") Integer roomID, @Param("resetRoomId") Integer resetRoomId);
}
