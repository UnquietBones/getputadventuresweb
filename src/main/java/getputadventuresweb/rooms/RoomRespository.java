package getputadventuresweb.rooms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  RoomRespository extends JpaRepository<RoomEntity, Integer> { }