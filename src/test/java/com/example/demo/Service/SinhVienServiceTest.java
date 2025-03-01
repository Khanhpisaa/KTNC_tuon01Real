package com.example.demo.Service;

import com.example.demo.Entity.SinhVien;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SinhVienServiceTest<svs> {

   private SinhVien sv1, sv2;
   private SinhVienService sinhVienService;

   @BeforeEach
    public void setUp(){
       sinhVienService = new SinhVienService();
       sv1 = new SinhVien("PH52275","Khanh",18,10,"PTPM");
       sv2 = new SinhVien("PH12345","Hiep",30,1,"PTPM");
       sinhVienService.addSinhVien(sv1);
       sinhVienService.addSinhVien(sv2);
   }
   @Test
    public void suaTuoiMax(){
       boolean kq = sinhVienService.sua(sv1,"PH52275","Khanh",70,10,"PTPM");
       Assertions.assertTrue(kq);
   }
   @Test
   public void addSV(){
      SinhVien sinhVien = new SinhVien("PH","namKhanh",20,9,"CNTT");
      sinhVienService.addSinhVien(sinhVien);
      Assertions.assertEquals(3,sinhVienService.getAllSinhVien().size());
   }
   @Test
   public void themMaRong() {
      SinhVien sinhVien = new SinhVien("", "namkhanh", 18, 8, "IT");
      Exception exception = assertThrows(IllegalArgumentException.class, () -> sinhVienService.addSinhVien(sinhVien));
      assertEquals("khong duoc de trong", exception.getMessage());
   }
}

