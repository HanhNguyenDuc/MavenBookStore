/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenbookstore.mainclass;

/**
 *
 * @author ADMIN
 */
public class Book {
    private int id;
    private String ten, nhaXuatBan;
    private int namXuatBan;
    private double gia;
    private String imgPath;
    private String description;
    private int amount;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book(int id, String ten, String nhaXuatBan, int namXuatBan, double gia, String imgPath) {
        this.setId(id);
        this.ten = ten;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
        this.gia = gia;
        this.setImgPath(imgPath);
    }

    public Book(int id, String ten, String nhaXuatBan, int namXuatBan, double gia, String imgPath, String description, int amount) {
        this.id = id;
        this.ten = ten;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
        this.gia = gia;
        this.imgPath = imgPath;
        this.description = description;
        this.amount = amount;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return this.ten;
    }

    public String getNhaXuatBan(){
        return this.nhaXuatBan;
    }
    
    public int getNamXuatBan(){
        return this.namXuatBan;
    }

    public double getGia(){
        return this.gia;
    }

    public int getAmount() {
    return this.amount;
    }
    
}
