package ru.context.practic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.context.practic.entity.Attendance;
import ru.context.practic.repository.AttendanceRepository;
import ru.context.practic.service.AttendanceService;
@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceRepository attendanceRepository;

    @Override
    public Attendance add(Attendance attendance) {
        return attendanceRepository.saveAndFlush(attendance);
    }

    @Override
    public void delete(Long id) {
        attendanceRepository.delete(attendanceRepository.getOne(id));

    }

    @Override
    public Attendance update(Attendance attendance) {
        if(!attendanceRepository.exists(Example.of(attendance))){
            return attendanceRepository.save(attendance);
        }
        else {
            throw new RuntimeException("Invalid");
        }
    }

    @Override
    public Attendance getById(Long id) {
        return attendanceRepository.getOne(id);
    }
}
