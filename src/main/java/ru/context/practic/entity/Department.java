package ru.context.practic.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    private Integer id;

    @Column
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "department")
    private List<Profession> profession;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
