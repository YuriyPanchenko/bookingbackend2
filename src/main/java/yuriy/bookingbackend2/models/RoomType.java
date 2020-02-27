package yuriy.bookingbackend2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;


    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "roomType")
    @JsonIgnore
    private Set<Room> rooms;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomType)) return false;
        RoomType roomType = (RoomType) o;
        return Objects.equals(getId(), roomType.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
