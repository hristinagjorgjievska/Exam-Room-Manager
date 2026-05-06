package mk.ukim.finki.wp.exam_room_manager.model.exceptions;

public class SubjectNotFoundException extends RuntimeException {
    public SubjectNotFoundException(Long subjectId) {
        super(String.format("Subject with id %d does not exist.", subjectId));
    }
}
