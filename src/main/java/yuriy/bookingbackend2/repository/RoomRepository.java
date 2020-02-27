package yuriy.bookingbackend2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import yuriy.bookingbackend2.models.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long> {
    public static String allFreeRooms = "SELECT r FROM Room r WHERE r.id NOT IN (SELECT DISTINCT b.room.id FROM Booking b WHERE (b.endLiving > :start AND b.endLiving <= :end) OR (b.startLiving>=:start AND b.startLiving < :end) OR (b.startLiving <= :start AND b.endLiving >= :end))";
    @Query(allFreeRooms)
    List<Room> allFreeRoomsOverNecessaryTime(@Param("start") LocalDate start,
                                             @Param("end") LocalDate end);
}
