package com.example.demo.Entity;

public class SinhVien {
    private String maSV;

    private String ten;

    private int tuoi;

    private float diemTB;

    private String chuyenNganh;

    public SinhVien() {
    }

    public SinhVien(String maSV, String ten, int tuoi, float diemTB, String chuyenNganh) {
        this.maSV = maSV;
        this.ten = ten;
        this.tuoi = tuoi;
        this.diemTB = diemTB;
        this.chuyenNganh = chuyenNganh;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSV='" + maSV + '\'' +
                ", ten='" + ten + '\'' +
                ", tuoi=" + tuoi +
                ", diemTB=" + diemTB +
                ", chuyenNganh='" + chuyenNganh + '\'' +
                '}';
    }
}
