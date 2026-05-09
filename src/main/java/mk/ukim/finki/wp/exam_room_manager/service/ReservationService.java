package mk.ukim.finki.wp.exam_room_manager.service;

import mk.ukim.finki.wp.exam_room_manager.model.Reservation;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface ReservationService {
    boolean hasConflict(Reservation reservation);
    List<Reservation> saveAll(List<Reservation> reservations);
    List<Reservation> findAllBySubjectId(Long subjectId);

    List<Reservation> findAll();
    Reservation findById(Long id);
    Reservation update(Long id, LocalTime startTime, int duration, int numberOfStudents, Long classroomId);
    void deleteById(Long id);
}
