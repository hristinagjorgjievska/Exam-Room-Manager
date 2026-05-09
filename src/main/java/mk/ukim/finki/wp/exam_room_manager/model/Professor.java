package mk.ukim.finki.wp.exam_room_manager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.wp.exam_room_manager.model.enums.ProfessorRole;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "professors")
@AllArgsConstructor
@NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Column(name = "full_name")
    private String fullName;
    private String email;

    @Column(name = "professor_role")
    @Enumerated(EnumType.STRING)
    private ProfessorRole professorRole;

    @OneToMany(mappedBy = "professor")
    private List<Subject> subjects = new ArrayList<>();

    public Professor(String username, String password, String fullName, String email, ProfessorRole professorRole) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.professorRole = professorRole;
    }
}