package mk.ukim.finki.wp.exam_room_manager.web;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.exam_room_manager.model.Professor;
import mk.ukim.finki.wp.exam_room_manager.service.ProfessorService;
import mk.ukim.finki.wp.exam_room_manager.service.SubjectService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final ProfessorService professorService;
    private final SubjectService subjectService;

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        Professor professor = professorService.findByUsername(userDetails.getUsername());
        model.addAttribute("professor", professor);
        model.addAttribute("subjects", subjectService.findByProfessor(professor));
        return "dashboard";
    }
}
