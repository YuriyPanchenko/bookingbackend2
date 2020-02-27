package yuriy.bookingbackend2.controllers.privateControllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yuriy.bookingbackend2.models.Booking;
import yuriy.bookingbackend2.repository.BookingRepository;

import java.util.List;

@RestController
public class NotConfirmedBooking {

    private final BookingRepository bookingRepository;

    public NotConfirmedBooking(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping(path = "/notConfirmedBooking")
    public List<Booking> getAllNotConfirmedBookings(){
        return bookingRepository.findAllByIsActive(false);
    }
}
