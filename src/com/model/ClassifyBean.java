package com.model;

/**
 * Created by Constantine on 2017/5/11.
 */
public class ClassifyBean {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassifyBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
