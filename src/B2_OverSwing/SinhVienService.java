/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B2_OverSwing;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class SinhVienService {

    private List<SinhVien> lists = new ArrayList<>();
    // interface = new class
//    private ArrayList<SinhVien>lists = new ArrayList<>();
    // CLass = new CLass 

    public SinhVienService() {
        lists.add(new SinhVien("PhongTT35", "Loại 1", true, "Ăn"));
        lists.add(new SinhVien("NguyenVV4", "Loại 2", true, "Ăn"));
        lists.add(new SinhVien("KhanhPG", "Loại 1", true, "Ăn"));
        lists.add(new SinhVien("HangNT169", "Loại 3", false, "Lăn"));
        lists.add(new SinhVien("TienNh21", "Loại 2", true, "Ăn"));
        lists.add(new SinhVien("DungNA29", "Loại 1", true, "Ăn"));
    }
    
    public List<SinhVien>getAll(){
        return lists;
    }

}
