package mk.ukim.finki.wp.exam_room_manager.model.exceptions;

public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException(String username) {
        super(String.format("The username: %s does not exist.", username));
    }
}
