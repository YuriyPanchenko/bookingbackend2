package yuriy.bookingbackend2.repository;

import org.springframework.data.repository.CrudRepository;
import yuriy.bookingbackend2.models.Booking;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Long> {
    public List<Booking> findAllByIsActive(Boolean isActive);
}
