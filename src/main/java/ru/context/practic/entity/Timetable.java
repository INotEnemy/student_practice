package ru.context.practic.entity;


import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private int num;

    @Column
    private Date startTime;

    @Column
    private Date endTime;

    @Column
    private String amountSubjects;

    @OneToMany(mappedBy = "timetable", fetch = FetchType.EAGER)
    private List<Teacher> teachers;

    public Timetable() {
    }

    public Integer getId() {
        return id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAmountSubjectsSubject() {
        return amountSubjects;
    }

    public void setAmountSubjectsSubject(String amountSubjects) {
        this.amountSubjects = amountSubjects;
    }

    public int getNum() {
        return num;
    }

    public void setNumber(int num) {
        this.num = num;
    }
}

