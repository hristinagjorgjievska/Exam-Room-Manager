package mk.ukim.finki.wp.exam_room_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.wp.exam_room_manager.model.enums.ExamType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "exams")
@AllArgsConstructor
@NoArgsConstructor
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exam_date")
    private LocalDate examDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "exam_type")
    @Enumerated(EnumType.STRING)
    private ExamType examType;

    private int duration;

    @Column(name = "number_of_students")
    private int numberOfStudents;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "exam")
    private List<Reservation> reservations = new ArrayList<>();

    public Exam(LocalDate examDate, LocalTime startTime, ExamType examType, int duration, int numberOfStudents, Subject subject) {
        this.examDate = examDate;
        this.startTime = startTime;
        this.examType = examType;
        this.duration = duration;
        this.numberOfStudents = numberOfStudents;
        this.subject = subject;
    }
}