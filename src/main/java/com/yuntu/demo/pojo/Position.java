package com.yuntu.demo.pojo;

public class Position {
    private int id;
    private String t_pos_name;


    public Position() {
    }

    public Position(int id, String t_pos_name) {
        this.id = id;
        this.t_pos_name = t_pos_name;
    }

    public Position(String t_pos_name) {
        this.t_pos_name = t_pos_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getT_pos_name() {
        return t_pos_name;
    }

    public void setT_pos_name(String t_pos_name) {
        this.t_pos_name = t_pos_name;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", t_pos_name='" + t_pos_name + '\'' +
                '}';
    }
}
