package com.example.recyclerview.model;

public class List1 {

    private int img1;
    private int img2;
    private String txt1;
    private String txt2;

    public List1(int img1, int img2, String txt1, String txt2) {
        this.img1 = img1;
        this.img2 = img2;
        this.txt1 = txt1;
        this.txt2 = txt2;
    }

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }

    public String getTxt1() {
        return txt1;
    }

    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }

    public String getTxt2() {
        return txt2;
    }

    public void setTxt2(String txt2) {
        this.txt2 = txt2;
    }
}
