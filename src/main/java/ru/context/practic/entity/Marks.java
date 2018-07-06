package ru.context.practic.entity;

import javax.persistence.*;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Entity
public class Marks {
    @Id
    private Long id;

    @Column
    private Date date;

    @Column
    private String subject;

    @Column
    private boolean attendance;

    @Column
    private double mark;


    @ManyToOne(fetch = FetchType.EAGER)

    @JoinColumn(name = "stud_id")
    private Student student;

    public Marks() {
    }

    public Marks(double mark) {
        this.date = new Date();
        this.mark = mark;
        this.attendance = attendance;
        this.subject = subject;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public boolean getAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public static Comparator<Marks> COMPARE_MARK = new Comparator<Marks>() {
        @Override
        public int compare(Marks m1, Marks m2) {
            if (m1.getMark() == m2.getMark()) return 0;
            else if(m1.getMark() > m2.getMark()) return 1;
            else return -1;
        }
    };
}


