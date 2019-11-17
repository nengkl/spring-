package top.neng.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component("xxx")
public class Xxx implements Serializable {
    private int id;
    private String xx2;

    public int getXx1() {
        return id;
    }

    public void setXx1(int xx1) {
        this.id = xx1;
    }

    public String getXx2() {
        return xx2;
    }

    public void setXx2(String xx2) {
        this.xx2 = xx2;
    }

    @Override
    public String toString() {
        return "Xxx{" +
                "xx1=" + id +
                ", xx2='" + xx2 + '\'' +
                '}';
    }
}
