package yuriy.bookingbackend2.controllers.publicControllers;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yuriy.bookingbackend2.models.Room;
import yuriy.bookingbackend2.repository.RoomRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BookingController {
    private final RoomRepository roomRepository;

    public BookingController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @PostMapping(path = "/booking")
    public List<Room> freeRooms(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end){
        return roomRepository.allFreeRoomsOverNecessaryTime(start, end);
    }
}
