package com.example.demo.Service;

import com.example.demo.Entity.SinhVien;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SinhVienServiceTest<svs> {

   private SinhVien sv1, sv2;
   private SinhVienService sinhVienService;

   @BeforeEach
    public void setUp(){
       sinhVienService = new SinhVienService();
       sv1 = new SinhVien("PH52275","NamKhanh",19,10,"PTPM");
       sv2 = new SinhVien("PH12345","Hiep",70,1,"PTPM");
       sinhVienService.addSinhVien(sv1);
       sinhVienService.addSinhVien(sv2);
   }
   // sửa
   @Test
    public void suaTuoiBienTren(){
       boolean kq = sinhVienService.sua(sv1,"PH52275","NamKhanh",70,10,"PTPM");
       Assertions.assertTrue(kq);
   }
   @Test
   public void suaTuoiCanBienTren(){
      boolean kq = sinhVienService.sua(sv1,"PH52275","NamKhanh",69,10,"PTPM");
      assertTrue(kq);
      Assertions.assertEquals(2,sinhVienService.getAllSinhVien().size());
   }
   @Test
   public void suaTuoiBienDuoi(){
      boolean kq = sinhVienService.sua(sv1,"PH52275","NamKhanh",18,10,"PTPM");
      assertTrue(kq);
      Assertions.assertEquals(2,sinhVienService.getAllSinhVien().size());
   }
   @Test
   public void suaTuoiCanBienDuoi(){
      boolean kq = sinhVienService.sua(sv1,"PH52275","NamKhanh",19,10,"PTPM");
      assertTrue(kq);
      Assertions.assertEquals(2,sinhVienService.getAllSinhVien().size());
   }
   @Test
   public void themTuoiKhongHopLe(){
      boolean kq = sinhVienService.sua(sv1,"PH52275","NamKhanh",16,10,"PTPM");
      assertTrue(kq);
      Assertions.assertEquals(2,sinhVienService.getAllSinhVien().size());
   }
   // thêm
   @Test
   public void addSVHopLe(){
      SinhVien sinhVien = new SinhVien("PH52275","namKhanh",20,9,"CNTT");
      sinhVienService.addSinhVien(sinhVien);
      Assertions.assertEquals(3,sinhVienService.getAllSinhVien().size());
   }
   @Test
   public void themMa1KiTu() {
      SinhVien sinhVien = new SinhVien("P", "NamKhanh", 18, 8, "IT");
      sinhVienService.addSinhVien(sinhVien);
      Assertions.assertEquals(3,sinhVienService.getAllSinhVien().size());
   }
   @Test
   public void ThemDiemBienDuoi(){
      SinhVien sinhVien = new SinhVien("PH52275","NamKhanh",18,0,"PTPM");
      sinhVienService.addSinhVien(sinhVien);
      Assertions.assertEquals(3,sinhVienService.getAllSinhVien().size());
   }
   @Test
   public void themDiemCanBienDuoi(){
      SinhVien sinhVien = new SinhVien("PH52275","NamKhanh",18,1,"PTPM");
      sinhVienService.addSinhVien(sinhVien);
      Assertions.assertEquals(3,sinhVienService.getAllSinhVien().size());
   }
   @Test
   public void themDiemBienTren(){
      SinhVien sinhVien = new SinhVien("PH52275","NamKhanh",18,10,"PTPM");
      sinhVienService.addSinhVien(sinhVien);
      Assertions.assertEquals(3,sinhVienService.getAllSinhVien().size());
   }

   //xóa
   @Test
   public void xoaTuoiBienDuoi(){
      SinhVien sinhVien = new SinhVien("PH52275","NamKhanh",18,10,"PTPM");
      sinhVienService.addSinhVien(sinhVien);
      boolean kq = sinhVienService.xoaSinhVien(18);
      assertTrue(kq);
      assertEquals(1,sinhVienService.getAllSinhVien().size());
   }

   @Test
   public void xoaTuoiCanBienDuoi(){
      SinhVien sinhVien = new SinhVien("PH52275","NamKhanh",19,10,"PTPM");
      sinhVienService.addSinhVien(sinhVien);
      boolean kq = sinhVienService.xoaSinhVien(19);
      assertTrue(kq);
      assertEquals(2,sinhVienService.getAllSinhVien().size());
   }
   @Test
   public void xoaTuoiBienTren(){
      SinhVien sinhVien = new SinhVien("PH52275","NamKhanh",70,10,"PTPM");
      sinhVienService.addSinhVien(sinhVien);
      boolean kq = sinhVienService.xoaSinhVien(70);
      assertTrue(kq);
      assertEquals(1,sinhVienService.getAllSinhVien().size());
   }

   @Test
   public void XoaTuoiCanBienTren(){
      SinhVien sinhVien = new SinhVien("PH52275","NamKhanh",69,10,"PTPM");
      sinhVienService.addSinhVien(sinhVien);
      boolean kq = sinhVienService.xoaSinhVien(69);
      assertTrue(kq);
      assertEquals(2,sinhVienService.getAllSinhVien().size());
   }

   @Test
   public void xoaTuoiKhongHopLe(){
      SinhVien sinhVien = new SinhVien("PH52275","NamKhanh",100,10,"PTPM");
      sinhVienService.addSinhVien(sinhVien);
      boolean kq = sinhVienService.xoaSinhVien(100);
      assertTrue(kq);
      assertEquals(2,sinhVienService.getAllSinhVien().size());
   }

   // tìm kiếm
   @Test
   public void timKiemMaCanBien(){
      SinhVien sinhVien = new SinhVien("2","Khanh",18,9,"PTPM");
      SinhVien sinhVien2 = new SinhVien("1","Khanh",18,9,"PTPM");
      sinhVienService.addSinhVien(sinhVien);
      sinhVienService.addSinhVien(sinhVien2);
      Optional<SinhVien> kq = sinhVienService.timSinhVien("1");
      Assertions.assertTrue(kq.isPresent(),"khong tim thay ma 2");
      assertEquals("1",kq.get().getMaSV());
   }
   @Test
   public void timKiemMaHopLe(){
      SinhVien sinhVien = new SinhVien("2","Khanh",18,9,"PTPM");
      SinhVien sinhVien2 = new SinhVien("1","Khanh",18,9,"PTPM");
      sinhVienService.addSinhVien(sinhVien);
      sinhVienService.addSinhVien(sinhVien2);
      Optional<SinhVien> kq = sinhVienService.timSinhVien("2");
      assertTrue(kq.isPresent(),"ma khong hop le");
      assertEquals("2",kq.get().getMaSV());
   }
   @Test
   public void TimkiemTuoiBienDuoi(){
      SinhVien sinhVien = new SinhVien("2","Khanh",18,9,"PTPM");
      SinhVien sinhVien2 = new SinhVien("1","Khanh",18,9,"PTPM");
      sinhVienService.addSinhVien(sinhVien);
      sinhVienService.addSinhVien(sinhVien2);
      Optional<SinhVien> kq = sinhVienService.timSinhVienTuoi(18);
      assertTrue(kq.isPresent(),"khong tim thay tuoi phu hop");
      assertEquals(18,kq.get().getTuoi());
   }
   @Test
   public void TimkiemTuoiBienDuoi1(){
      SinhVien sinhVien = new SinhVien("2","Khanh",18,9,"PTPM");
      SinhVien sinhVien2 = new SinhVien("1","Khanh",18,9,"PTPM");
      sinhVienService.addSinhVien(sinhVien);
      sinhVienService.addSinhVien(sinhVien2);
      Optional<SinhVien> kq = sinhVienService.timSinhVienTuoi(18);
      assertTrue(kq.isPresent(),"khong tim thay tuoi phu hop");
      assertEquals(18,kq.get().getTuoi());
   }
   @Test
   public void timKiemTuoiCanBienDuoi(){
      SinhVien sinhVien = new SinhVien("2","Khanh",19,9,"PTPM");
      SinhVien sinhVien2 = new SinhVien("1","Khanh",18,9,"PTPM");
      sinhVienService.addSinhVien(sinhVien);
      sinhVienService.addSinhVien(sinhVien2);
      Optional<SinhVien> kq = sinhVienService.timSinhVienTuoi(19);
      assertTrue(kq.isPresent(),"Khong tim thay tuoi");
      assertEquals(19,kq.get().getTuoi());
   }
   @Test
   public void timKiemTuoiBienTren(){
      SinhVien sinhVien = new SinhVien("2","Khanh",70,9,"PTPM");
      SinhVien sinhVien2 = new SinhVien("1","Khanh",18,9,"PTPM");
      sinhVienService.addSinhVien(sinhVien);
      sinhVienService.addSinhVien(sinhVien2);
      Optional<SinhVien> kq = sinhVienService.timSinhVienTuoi(70);
      assertTrue(kq.isPresent(),"khong tim thay tuoi phu hop");
      assertEquals(70,kq.get().getTuoi());
   }
   @Test
   public void timkiemcanbienTren(){
      SinhVien sinhVien = new SinhVien("2","Khanh",70,9,"PTPM");
      SinhVien sinhVien2 = new SinhVien("1","Khanh",69,9,"PTPM");
      sinhVienService.addSinhVien(sinhVien);
      sinhVienService.addSinhVien(sinhVien2);
      Optional<SinhVien> kq = sinhVienService.timSinhVienTuoi(69);
      assertTrue(kq.isPresent(),"khong co tuoi phu hop");
      assertEquals(69,kq.get().getTuoi());
   }
}

