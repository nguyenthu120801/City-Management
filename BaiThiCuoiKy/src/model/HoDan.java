/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Bách Trần
 */
public class HoDan {
    String maHoDan;
    String soNha;
    int soThanhVien;
    String maKhuPho;

    public HoDan(String maHoDan, String soNha, int soThanhVien, String maKhuPho) {
        this.maHoDan = maHoDan;
        this.soNha = soNha;
        this.soThanhVien = soThanhVien;
        this.maKhuPho = maKhuPho;
    }

    public String getMaHoDan() {
        return maHoDan;
    }

    public String getSoNha() {
        return soNha;
    }

    public int getSoThanhVien() {
        return soThanhVien;
    }

    public String getMaKhuPho() {
        return maKhuPho;
    }

    public void setMaHoDan(String maHoDan) {
        this.maHoDan = maHoDan;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public void setSoThanhVien(int soThanhVien) {
        this.soThanhVien = soThanhVien;
    }

    public void setMaKhuPho(String maKhuPho) {
        this.maKhuPho = maKhuPho;
    }
    
    
}
