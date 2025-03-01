package com.example.demo.Utils;

public class TinhTongNNguyen {
    public int tinhTongNNguyen(int [] daySO){
       int tinhTong = 0;
        for (int so: daySO){
            tinhTong += so;
        }
        return tinhTong;
    }
}
