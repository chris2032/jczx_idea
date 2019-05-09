package com.jczx.model52;

public class Uh {
    Integer id;
    String yh;
    String mm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYh() {
        return yh;
    }

    public void setYh(String yh) {
        this.yh = yh;
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }

    @Override
    public String toString() {
        return "Uh{" +
                "id=" + id +
                ", yh='" + yh + '\'' +
                ", mm='" + mm + '\'' +
                '}';
    }
}
