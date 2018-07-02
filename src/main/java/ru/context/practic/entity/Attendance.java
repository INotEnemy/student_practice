package ru.context.practic.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Date data;

    @Column
    private boolean attendance;

    public Attendance() {
    }

    public Attendance(boolean attendance) {
        this.data = new Date();
        this.attendance = attendance;
    }

    @OneToMany(mappedBy = "attendanceToday", fetch = FetchType.EAGER)
    private List<Student> students;

    public Integer getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean getAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }
}
