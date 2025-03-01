package com.example.demo.Service;

import com.example.demo.Entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    private List<SinhVien> sinhVienList = new ArrayList<>();

    public void addSinhVien(SinhVien sinhVien){
        if (sinhVien == null){
            throw new IllegalArgumentException("Sinh Vien Khong duoc de trong");
        }
        if (sinhVien.getMaSV() == null || sinhVien.getMaSV().trim().isEmpty() || sinhVien.getChuyenNganh() == null || sinhVien.getChuyenNganh().trim().isEmpty() ||
                sinhVien.getTen() == null || sinhVien.getTen().trim().isEmpty()){
                throw new IllegalArgumentException("khong duoc de trong");
        }
        if (sinhVien.getTuoi() > 70 || sinhVien.getTuoi() < 18){
            throw new IllegalArgumentException("khong duoc de trong");
        }
        if (sinhVien.getDiemTB() > 10 || sinhVien.getDiemTB() < 0){
            throw new IllegalArgumentException("khong duoc de trong");
        }
        sinhVienList.add(sinhVien);
    }

    public SinhVien getSinhVienByMa(String maSV){
        for (SinhVien sinhVien : sinhVienList){
            if (sinhVien.getMaSV().equals(maSV)){
                return sinhVien;
            }
        }
        return null;
    }
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
    public boolean deleteSinhVien( String maSV){
        for (int i = 0; i < sinhVienList.size() ; ++i){
            if (sinhVienList.get(i).getMaSV().equals(maSV) ){
            sinhVienList.remove(i);
            return true;
            }
        }
    return false;
    }
    public List<SinhVien> getAllSinhVien(){
        return new ArrayList<>(sinhVienList);
    }
}
