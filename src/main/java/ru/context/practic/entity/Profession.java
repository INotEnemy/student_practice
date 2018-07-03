package ru.context.practic.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Profession {

    @Id
    private Integer id;

    @Column
    private String profession;
    public Profession() {
    }

    public Profession(String profession) {
        this.profession = profession;
    }

    public Integer getId() {
        return id;
    }

    @OneToMany(mappedBy = "profession", fetch = FetchType.EAGER)
    private List<Student> students;

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }


}
