package ru.context.practic.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Post {

    @Id
    private Integer id;

    @Column
    private String name;

    @OneToMany(mappedBy = "post")
    private List<Teacher> teachers;

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

