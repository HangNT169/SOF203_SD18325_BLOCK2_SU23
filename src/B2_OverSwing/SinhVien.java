/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B2_OverSwing;

/**
 *
 * @author hangnt
 */
public class SinhVien {

    private String ten;
    private String loai;
    private boolean gioiTinh;
    private String soThich;

    public SinhVien() {
    }

    public SinhVien(String ten, String loai, boolean gioiTinh, String soThich) {
        this.ten = ten;
        this.loai = loai;
        this.gioiTinh = gioiTinh;
        this.soThich = soThich;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoThich() {
        return soThich;
    }

    public void setSoThich(String soThich) {
        this.soThich = soThich;
    }

}
