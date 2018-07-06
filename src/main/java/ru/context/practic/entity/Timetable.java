package ru.context.practic.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Timetable {

    @Id
    private Integer id;

    @Column
    private Date startTime;

    @Column
    private Date endTime;

    @Column
    private String amountSubjects;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tech_id")
    private Teacher teacher;

    public Timetable() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


}

