package ru.context.practic.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Date data;

    @Column
    private double mark;

    @OneToMany(mappedBy = "bestMarkToday", fetch = FetchType.EAGER)
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

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
