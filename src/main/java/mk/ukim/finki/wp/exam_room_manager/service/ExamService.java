package mk.ukim.finki.wp.exam_room_manager.service;

import mk.ukim.finki.wp.exam_room_manager.model.Exam;
import mk.ukim.finki.wp.exam_room_manager.model.Subject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ExamService {
    Exam createExam(LocalDate exam_date, LocalTime start_time, int duration, int number_of_students, Subject subject);
    List<Exam> findAllBySubject(Subject subject);
}
