import java.util.ArrayList;
class Sach {
    public String maSach;
    public String tieuDe;
    public String tacGia;
    public int namXuatBan;
    public int soLuong;

    // Constructor
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }
    public void hienThiThongTin() {
        System.out.println("Mã sách: [" + maSach + "] | Tiêu đề: " + tieuDe +
                " | Tác giả: " + tacGia + " | Năm XB: " + namXuatBan +
                " | Số lượng: " + soLuong);
    }
}