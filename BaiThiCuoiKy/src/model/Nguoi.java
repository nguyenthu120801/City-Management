/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Bách Trần
 */
public class Nguoi {
    String maNguoi;
    int tuoi;
    int namSinh;
    String hoVaTen;
    String ngheNghiep;
    String maHoDan;

    public void setMaNguoi(String maNguoi) {
        this.maNguoi = maNguoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public void setMaHoDan(String maHoDan) {
        this.maHoDan = maHoDan;
    }

    public String getMaNguoi() {
        return maNguoi;
    }

    public int getTuoi() {
        return tuoi;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public String getMaHoDan() {
        return maHoDan;
    }

    public Nguoi(String maNguoi, int tuoi, int namSinh, String hoVaTen, String ngheNghiep, String maHoDan) {
        this.maNguoi = maNguoi;
        this.tuoi = tuoi;
        this.namSinh = namSinh;
        this.hoVaTen = hoVaTen;
        this.ngheNghiep = ngheNghiep;
        this.maHoDan = maHoDan;
    }
}
