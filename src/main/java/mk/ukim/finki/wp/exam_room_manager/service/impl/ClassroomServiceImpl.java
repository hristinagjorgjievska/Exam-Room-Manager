package mk.ukim.finki.wp.exam_room_manager.service.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.exam_room_manager.model.Classroom;
import mk.ukim.finki.wp.exam_room_manager.model.enums.ComputerAvailability;
import mk.ukim.finki.wp.exam_room_manager.model.exceptions.ClassroomNotFoundException;
import mk.ukim.finki.wp.exam_room_manager.repository.ClassroomRepository;
import mk.ukim.finki.wp.exam_room_manager.service.ClassroomService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;

    @Override
    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    @Override
    public List<Classroom> findByComputerAvailability(ComputerAvailability computer_availability) {
        return classroomRepository.findAllByComputerAvailability(computer_availability);
    }

    @Override
    public Classroom findById(Long id) {
        return classroomRepository.findById(id).orElseThrow(() -> new ClassroomNotFoundException(id));
    }
}
