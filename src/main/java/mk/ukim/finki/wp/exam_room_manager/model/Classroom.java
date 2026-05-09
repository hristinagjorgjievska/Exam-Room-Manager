package mk.ukim.finki.wp.exam_room_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.wp.exam_room_manager.model.enums.ComputerAvailability;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "classrooms")
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int capacity;

    @Column(name = "computer_availability")
    @Enumerated(EnumType.STRING)
    private ComputerAvailability computerAvailability;

    @OneToMany(mappedBy = "classroom")
    private List<Reservation> reservations = new ArrayList<>();

    public Classroom(String name, int capacity, ComputerAvailability computerAvailability) {
        this.name = name;
        this.capacity = capacity;
        this.computerAvailability = computerAvailability;
    }
}