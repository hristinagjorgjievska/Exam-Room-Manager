package mk.ukim.finki.wp.exam_room_manager.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
