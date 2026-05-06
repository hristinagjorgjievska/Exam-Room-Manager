package mk.ukim.finki.wp.exam_room_manager.service.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.exam_room_manager.model.Professor;
import mk.ukim.finki.wp.exam_room_manager.model.Subject;
import mk.ukim.finki.wp.exam_room_manager.model.exceptions.SubjectNotFoundException;
import mk.ukim.finki.wp.exam_room_manager.repository.SubjectRepository;
import mk.ukim.finki.wp.exam_room_manager.service.SubjectService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public List<Subject> findByProfessor(Professor professor) {
        return subjectRepository.findAllByProfessor(professor);
    }

    @Override
    public Subject findById(Long id) {
        return subjectRepository.findById(id).orElseThrow(() -> new SubjectNotFoundException(id));
    }
}
