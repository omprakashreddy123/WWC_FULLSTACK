package com.example.demo.model;

public class Event {

    private Integer id;
    private String name;
    private String course;

    public Event() {}

    public Event(Integer id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

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

    public String getLocation() {
        return course;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
