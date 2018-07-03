package ru.context.practic.entity;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.util.ArrayList;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column
    private double load;

    @ManyToOne
    @JoinColumn(name = "tt_id")
    private Timetable timetable;

    public Teacher() {
    }

    public Teacher(Long id, String firstName, String lastName, double load) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.load = load;
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

    public String getDepartment() {
        return department.getName();
    }

    public void setDepartment(String department) {
        this.department.setName(department);
    }

    public String getPost() {
        return post.getName();
    }

    public void setPost(String post) {
        this.post.setName(post);
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    public Timetable getTimetable() {
        return timetable;
    }


}
