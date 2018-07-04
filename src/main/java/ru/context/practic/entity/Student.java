package ru.context.practic.entity;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "prof_id")
    private Profession profession;

    @Column
    private int level;

    @ManyToOne
    @JoinColumn(name = "mark_id")
    private Marks bestMarkToday;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, Profession profession, int level, Marks marks) {
        this.setProfession(profession);
        this.setBestMarkToday(marks);
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Marks getBestMarkToday() {
        return bestMarkToday ;
    }

    public void setBestMarkToday(Marks mark) {
        this.bestMarkToday = mark;
    }

}