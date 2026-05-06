package mk.ukim.finki.wp.exam_room_manager.model.exceptions;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(Long reservationId) {
        super(String.format("Reservation with id %d does not exist.", reservationId));
    }
}
