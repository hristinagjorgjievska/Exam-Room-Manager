package mk.ukim.finki.wp.exam_room_manager.model.exceptions;

public class ConflictException extends RuntimeException {
    public ConflictException(String name) {
        super(String.format("Classroom with the name %s already exits.", name));
    }
}
