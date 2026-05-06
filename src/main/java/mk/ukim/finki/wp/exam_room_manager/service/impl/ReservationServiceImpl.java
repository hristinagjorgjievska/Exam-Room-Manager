package mk.ukim.finki.wp.exam_room_manager.service.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.exam_room_manager.model.Classroom;
import mk.ukim.finki.wp.exam_room_manager.model.Reservation;
import mk.ukim.finki.wp.exam_room_manager.model.exceptions.ReservationNotFoundException;
import mk.ukim.finki.wp.exam_room_manager.repository.ReservationRepository;
import mk.ukim.finki.wp.exam_room_manager.service.ReservationService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public boolean hasConflict(Reservation reservation) {
        LocalDate date = reservation.getExam().getExamDate();
        Classroom classroom = reservation.getClassroom();
        List<Reservation> existing = reservationRepository.findAllByClassroomAndExam_ExamDate(classroom, date);

        LocalTime newStart = reservation.getExam().getStartTime();
        LocalTime newEnd = newStart.plusMinutes(reservation.getExam().getDuration());

        for (Reservation r : existing) {
            LocalTime existingStart = r.getExam().getStartTime();
            LocalTime existingEnd = existingStart.plusMinutes(r.getExam().getDuration());

            if (existingStart.isBefore(newEnd) && existingEnd.isAfter(newStart)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Reservation> saveAll(List<Reservation> reservations) {
        for (Reservation reservation : reservations)
        {
            if (hasConflict(reservation))
            {
                throw new RuntimeException("Classroom " + reservation.getClassroom().getName() + " is already booked at that time.");
            }
        }
        return reservationRepository.saveAll(reservations);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
    }

    @Override
    public Reservation create(Reservation reservation) {
        if (hasConflict(reservation)) {
            throw new RuntimeException("Reservation conflict exists");
        }
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation update(Long id, Reservation reservation) {
        Reservation existingReservation = reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
        existingReservation.setClassroom(reservation.getClassroom());
        existingReservation.setExam(reservation.getExam());
        return reservationRepository.save(existingReservation);
    }

    @Override
    public void delete(Long id) {
        this.reservationRepository.deleteById(id);
    }
}
