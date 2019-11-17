package top.neng.entity;

import java.io.Serializable;

public class Xxx implements Serializable {

    private int id;

    private String name;

    private int pw;

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

    public int getPw() {
        return pw;
    }

    public void setPw(int pw) {
        this.pw = pw;
    }

    @Override
    public String toString() {
        return "Xxx{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pw=" + pw +
                '}';
    }
}
