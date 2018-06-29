package ru.context.practic.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private int data;

    @Column
    private boolean attendance;

    @OneToMany(mappedBy = "attendanceToday", fetch = FetchType.EAGER)
    private List<Student> students;

    public Integer getId() {
        return id;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean getAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }
}
