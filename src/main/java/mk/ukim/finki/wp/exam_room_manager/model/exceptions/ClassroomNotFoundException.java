package mk.ukim.finki.wp.exam_room_manager.model.exceptions;

public class ClassroomNotFoundException extends RuntimeException {
    public ClassroomNotFoundException(Long classroomId) {
        super(String.format("Classroom with id %d does not exist.", classroomId));
    }
}
