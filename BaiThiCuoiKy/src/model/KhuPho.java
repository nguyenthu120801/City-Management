/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Bách Trần
 */
public class KhuPho {
    String maKhuPho;
    String tenKhuPho;

    public KhuPho() {
    }

    public void setMaKhuPho(String maKhuPho) {
        this.maKhuPho = maKhuPho;
    }

    public void setTenKhuPho(String tenKhuPho) {
        this.tenKhuPho = tenKhuPho;
    }

    public String getMaKhuPho() {
        return maKhuPho;
    }

    public String getTenKhuPho() {
        return tenKhuPho;
    }

    public KhuPho(String maKhuPho, String tenKhuPho) {
        this.maKhuPho = maKhuPho;
        this.tenKhuPho = tenKhuPho;
    }

    @Override
    public String toString() {
        return  maKhuPho + tenKhuPho;
    }
}
