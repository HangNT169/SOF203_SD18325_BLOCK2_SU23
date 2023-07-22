/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B9_CRUDJDBC.service;

import B9_CRUDJDBC.model.GiangVien;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author hangnt
 */
public class GiangVienService {
    // CRUD(CREATE - READ - UPDATE - DELETE)
    // INSERT INTO - SELECT - UPDATE - DELETE

    // GET ALL => SELECT => Nhieu dong => 1 mang (LIST hoac ARRAYLIST..)
    public List<GiangVien> getAll() {
        // B1: Viet cau SQL 
        String sql = """
                   SELECT ma, ten, loai, tuoi, bac, gioi_tinh
                     FROM QLGV.dbo.giang_vien;
                   """;
        // B2: Mo cong ket noi
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<GiangVien>lists = new ArrayList<>();
            // code 
            while (rs.next()) {                
                // Doc du lieu tu bang
                GiangVien gv = new GiangVien();
                gv.setBac(rs.getInt(5));
                gv.setGioiTinh(rs.getBoolean(6));
                gv.setLoai(rs.getString(3));
                gv.setMa(rs.getString(1));
                gv.setTen(rs.getString(2));
                gv.setTuoi(rs.getInt(4));
                // add phan tu vao list
                lists.add(gv);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        List<GiangVien>lists = new GiangVienService().getAll();
        System.out.println(lists);
    }
}
