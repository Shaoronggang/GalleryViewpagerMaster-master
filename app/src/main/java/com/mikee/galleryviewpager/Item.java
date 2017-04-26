package com.mikee.galleryviewpager;

import java.io.Serializable;

/**
 * Created by shaoronggang on 2017/3/1.
 * item相关的类
 */

public class Item implements Serializable {
    private int position;
    private int img;
    private String name;
    private String nation;
    private String des;
    private boolean isSelected;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Item{" +
                "des='" + des + '\'' +
                ", position=" + position +
                ", img=" + img +
                ", name='" + name + '\'' +
                ", nation='" + nation + '\'' +
                ", isSelected=" + isSelected +
                '}';
    }
}
