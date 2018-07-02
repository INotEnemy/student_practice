package ru.context.practic.service;

import ru.context.practic.entity.Attendance;

public interface AttendanceService {

     Attendance add(Attendance attendance);

     void delete(Long id);

     Attendance update(Attendance attendance);

     Attendance getById(Long id);


}
