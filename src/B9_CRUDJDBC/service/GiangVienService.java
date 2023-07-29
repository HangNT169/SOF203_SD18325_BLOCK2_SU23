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
            List<GiangVien> lists = new ArrayList<>();
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

    public GiangVien getOne(String ma1) {
        // B1: Viet cau SQL 
        String sql = """
                   SELECT [ma]
                           ,[ten]
                           ,[loai]
                           ,[tuoi]
                           ,[bac]
                           ,[gioi_tinh]
                       FROM [dbo].[giang_vien]
                       WHERE ma = ? 
                   """;
        // B2: Mo cong ket noi
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            // Truyen gia tri cho dau ?
            ps.setObject(1, ma1);
//            ps.setObject(2, tuoi);
//            ps.setObject(3, bac);
            ResultSet rs = ps.executeQuery(); // dong nay la doc ket qua tu sql
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
                return gv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update, Add, Delete => Tra ra 1 hoac 0 dong thanh cong 
    // => Boolean 
    public Boolean delete(String ma) {
        int check = 0;
        String sql = """
                   DELETE FROM QLGV.dbo.giang_vien
                   WHERE ma = ?;
                   """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            // Truyen gia tri cho dau ?
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public Boolean add(GiangVien gv) {
        int check = 0;
        String sql = """
                   INSERT INTO QLGV.dbo.giang_vien
                   (ma, ten, loai, tuoi, bac, gioi_tinh)
                   VALUES(?,?,?,?,?,?);
                   """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            // Truyen gia tri cho dau ?
            ps.setObject(1, gv.getMa());
            ps.setObject(2, gv.getTen());
            ps.setObject(3, gv.getLoai());
            ps.setObject(4, gv.getTuoi());
            ps.setObject(5, gv.getBac());
            ps.setObject(6, gv.getGioiTinh());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public static void main(String[] args) {
        System.out.println(new GiangVienService().delete("NguyenVV4"));
//        List<GiangVien>lists = new GiangVienService().getAll();
//        System.out.println(lists);
//        GiangVien gv = new GiangVienService().getOne("NguyenVV4");
//        System.out.println(gv);
    }
}
