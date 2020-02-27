package yuriy.bookingbackend2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private double price;
    private int capasity;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "room_type_id", nullable = false)
    private RoomType roomType;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "room")
    @JsonIgnore
    private Set<Booking> bookings;
}
