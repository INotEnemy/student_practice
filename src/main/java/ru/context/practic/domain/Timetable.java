package ru.context.practic.domain;


import javax.persistence.*;

@Entity
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private int num;

    @Column
    private int startTime;

    @Column
    private int endTime;

    @Column
    private String subject;

    @Column
    private int room;

    public Timetable() {
    }

    public Integer getId() {
        return id;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getNum() {
        return num;
    }

    public void setNumber(int num) {
        this.num = num;
    }


}
