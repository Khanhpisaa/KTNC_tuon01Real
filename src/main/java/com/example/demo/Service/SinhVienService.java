package com.example.demo.Service;

import com.example.demo.Entity.SinhVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SinhVienService {
    private List<SinhVien> sinhVienList = new ArrayList<>();
    private SinhVien sinhVien = new SinhVien();

    // thêm
    public void addSinhVien(SinhVien sinhVien){
        if (sinhVien == null){
            throw new IllegalArgumentException("Sinh Vien Khong duoc de trong");
        }
        if (sinhVien.getMaSV() == null || sinhVien.getMaSV().trim().isEmpty() || sinhVien.getChuyenNganh() == null || sinhVien.getChuyenNganh().trim().isEmpty() ||
                sinhVien.getTen() == null || sinhVien.getTen().trim().isEmpty()){
                throw new IllegalArgumentException("khong duoc de trong");
        }
        if (sinhVien.getTuoi() > 70 || sinhVien.getTuoi() < 18){
            throw new IllegalArgumentException("Tuoi khong hop le");
        }
        if (sinhVien.getDiemTB() > 10 || sinhVien.getDiemTB() < 0){
            throw new IllegalArgumentException("Diem khon hop le");
        }
        sinhVienList.add(sinhVien);
    }

    //sửa
    public boolean sua(SinhVien sinhVien, String maMoi, String tenMoi, int tuoiMoi, float diemTBMoi, String chuyenNganhMoi){
        if ( maMoi == null || maMoi.trim().isEmpty() || tenMoi == null || tenMoi.trim().isEmpty() || chuyenNganhMoi == null || chuyenNganhMoi.trim().isEmpty() ){
            throw new IllegalArgumentException("Khong duoc de trong");
        }
        if (tuoiMoi < 18 || tuoiMoi > 70){
            throw new IllegalArgumentException("Thong tin khong hop le");
        }
        if (diemTBMoi >10 || diemTBMoi < 0){
            throw new IllegalArgumentException("Thong tin khong hop le");
        }
        sinhVien.setMaSV(maMoi);
        sinhVien.setTen(tenMoi);
        sinhVien.setTuoi(tuoiMoi);
        sinhVien.setDiemTB(diemTBMoi);
        sinhVien.setChuyenNganh(chuyenNganhMoi);
        return true;
    }

    //xoa
    public boolean xoaSinhVien(int tuoi){
        return sinhVienList.removeIf(s -> s.getTuoi()==tuoi);
    }

    // tim kiem
    public Optional<SinhVien> timSinhVien(String maSV) {
        return sinhVienList.stream()
                .filter(s -> s.getMaSV().equals(maSV))
                .findFirst();
    }
    public Optional<SinhVien> timSinhVienTuoi(int tuoi) {
        return sinhVienList.stream()
                .filter(s -> s.getTuoi() == tuoi)
                .findFirst();
    }


    public List<SinhVien> getAllSinhVien(){
        return new ArrayList<>(sinhVienList);
    }
}
