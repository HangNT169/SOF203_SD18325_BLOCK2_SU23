package B3_CRUDListFixCung.service;

import B3_CRUDListFixCung.entity.DongVat;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author hangnt
 */
public class DongVatService {

    private List<DongVat> list = new ArrayList<>();

    public DongVatService() {
        list.add(new DongVat("01", "cho", 50, true, "nha"));
        list.add(new DongVat("02", "meo", 30, true, "nha"));
        list.add(new DongVat("03", "ga", 5, true, "trangtrai"));
        list.add(new DongVat("04", "vit", 4, true, "trangtrai"));
    }

    public List<DongVat> getAll() {
        return list;
    }

    public void removeDongVat(int viTri) {
        list.remove(viTri);
    }

    public void addDongVat(DongVat dongVat) {
        list.add(dongVat);
    }

    public void updateDongVat(int viTri, DongVat dongVat) {
        list.set(viTri, dongVat);
    }

    public void sapXep() {
        // SS chuoi
//        list.sort((o1, o2) -> {
//            return o1.getTenDV().compareTo(o2.getTenDV()); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/LambdaBody
//        });
        // SS so 
        list.sort((o1, o2) -> {
            return o1.getCanNang() - o2.getCanNang(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/LambdaBody
        });
    }

}
