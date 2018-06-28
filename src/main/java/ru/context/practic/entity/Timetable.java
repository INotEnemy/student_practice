package ru.context.practic.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private int num;

    @Column
    private int startTime;

    @Column
    private int endTime;

    @Column
    private String amountSubjects;

    @OneToMany(mappedBy = "timetable", fetch = FetchType.EAGER)
    private List<Teacher> teachers;

    public Timetable() {
    }

    public Integer getId() {
        return id;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
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

