package ru.context.practic.entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String profession;

    @Column
    private int level;

    @OneToMany
    private ArrayList<Marks> marks;

    @OneToMany
    private ArrayList<Attendance> attendance ;

    public Student() {
    }

    public Student(Integer id, String firstName, String lastName) {
        this.id =  id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = 1;
        this.marks = null;
        this.attendance = null;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}