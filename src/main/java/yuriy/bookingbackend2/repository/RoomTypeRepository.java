package yuriy.bookingbackend2.repository;

import org.springframework.data.repository.CrudRepository;
import yuriy.bookingbackend2.models.RoomType;

public interface RoomTypeRepository extends CrudRepository<RoomType, Long> {
}
