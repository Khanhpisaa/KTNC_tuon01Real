package com.example.demo.Utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTinhTong {
    TinhTongNNguyen tinhTongNNguyen = new TinhTongNNguyen();
    @Test
    public void tong01(){
        int [] daySo = {1,2,3,4,5};
        Assertions.assertEquals(15,tinhTongNNguyen.tinhTongNNguyen(daySo));

    }
    @Test
    public void tong02(){
        int [] daySo = {1,2,3,4,5,6,7};
        Assertions.assertEquals(28,tinhTongNNguyen.tinhTongNNguyen(daySo));
    }
    @Test
    public void tong03(){
        int [] daySo = {1,2,3,4,5,6,7,3};
        Assertions.assertEquals(30,tinhTongNNguyen.tinhTongNNguyen(daySo));
    }
    @Test
    public void tong04(){
        int [] daySo = {1,2,3,4,5,6,7,3,10};
        Assertions.assertEquals(10,tinhTongNNguyen.tinhTongNNguyen(daySo));
    }
    @Test
    public void tong05(){
        int [] daySo = {1,2,3,4,5,6,7,3,10,20};
        Assertions.assertEquals(61,tinhTongNNguyen.tinhTongNNguyen(daySo));
    }
}
