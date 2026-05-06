package mk.ukim.finki.wp.exam_room_manager.service.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.exam_room_manager.model.Professor;
import mk.ukim.finki.wp.exam_room_manager.model.exceptions.UsernameNotFoundException;
import mk.ukim.finki.wp.exam_room_manager.repository.ProfessorRepository;
import mk.ukim.finki.wp.exam_room_manager.service.ProfessorService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService, UserDetailsService {

    private final ProfessorRepository professorRepository;

    @Override
    public Professor findByUsername(String username) {
        return professorRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Professor professor = professorRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("A professor with the username: " + username + " wasn't found in the database"));

        return new org.springframework.security.core.userdetails.User(professor.getUsername(), professor.getPassword(), List.of(new SimpleGrantedAuthority(professor.getProfessorRole().name())));
    }
}
