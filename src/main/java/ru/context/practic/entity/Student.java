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

    @ManyToOne
    @JoinColumn(name = "attend_id")
    private Attendance attendanceToday;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, Profession profession, int level, double marks) {
        this.setProfession(profession);

       // this.bestMarkToday = new Marks(marks);
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        //this.attendanceToday.setAttendance(true);
        // this.attendanceToday.setData("");
    }

    public Long getId() {
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

    public double getBestMarkToday() {
        return bestMarkToday.getMark();
    }

    public void setBestMarkToday(double mark) {
        this.bestMarkToday.setMark(mark);
    }

    public Attendance getAttendanceToday() {
        return attendanceToday;
    }
}