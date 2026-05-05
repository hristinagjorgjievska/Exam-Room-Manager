package mk.ukim.finki.wp.exam_room_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate examDate;
    private LocalTime startTime;
    private int duration;
    private int numberOfStudents;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "exam")
    private List<Reservation> reservations = new ArrayList<>();

    public Exam(LocalDate examDate, LocalTime startTime, int duration, int numberOfStudents, Subject subject) {
        this.examDate = examDate;
        this.startTime = startTime;
        this.duration = duration;
        this.numberOfStudents = numberOfStudents;
        this.subject = subject;
    }
}


//id, examDate (LocalDate), startTime (LocalTime), duration (int, minutes), numberOfStudents (int)
//Relationship: many exams → one subject (@ManyToOne), one exam → many reservations (@OneToMany)