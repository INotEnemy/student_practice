package ru.context.practic.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Marks {
    @Id

    private Long id;

    @Column
    private Date date;

    @Column
    private double mark;


    @OneToMany(mappedBy = "bestMarkToday", fetch = FetchType.EAGER)
    private List<Student> students;

    public Marks() {
    }

    public Marks(double mark) {
        this.date = new Date();
        this.mark = mark;
    }

    public Long getId() {
        return id;
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
}
