import java.util.Scanner;
import java.time.Year;

public class bttuan3 {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXB;
    private double donGia;
    private int soLuong;
    private String loaiSach;
    public void nhap(Scanner sc) {
        int namHienTai = Year.now().getValue();
        System.out.print("Nhập mã sách: ");
        this.maSach = sc.nextLine();
        System.out.print("Nhập tên sách: ");
        this.tenSach = sc.nextLine();
        System.out.print("Nhập tác giả: ");
        this.tacGia = sc.nextLine();

        System.out.println("--- Chọn loại sách ---");
        System.out.println("1. Sách giáo khoa");
        System.out.println("2. Sách tham khảo");
        System.out.println("3. Sách chuyên ngành");
        System.out.println("4. Sách khác");
        System.out.print("Lựa chọn của bạn (1-4): ");
        int chon = sc.nextInt();

        switch (chon) {
            case 1:
                this.loaiSach = "Sách giáo khoa";
                break;
            case 2:
                this.loaiSach = "Sách tham khảo";
                break;
            case 3:
                this.loaiSach = "Sách chuyên ngành";
                break;
            default:
                this.loaiSach = "Sách khác";
                break;
        }

        do {
            System.out.print("Nhập năm xuất bản: ");
            this.namXB = sc.nextInt();
            if (this.namXB > namHienTai || this.namXB <= 0) {
                System.out.println("Lỗi: Năm xuất bản phải từ 1 đến " + namHienTai + ". Vui lòng nhập lại!");
            }
        } while (this.namXB > namHienTai || this.namXB <= 0);
        do {
            System.out.print("Nhập đơn giá: ");
            this.donGia = sc.nextDouble();
            if (this.donGia < 0) {
                System.out.println("Lỗi: Đơn giá không được âm. Vui lòng nhập lại!");
            }
        } while (this.donGia < 0);
        do {
            System.out.print("Nhập số lượng: ");
            this.soLuong = sc.nextInt();
            if (this.soLuong < 0) {
                System.out.println("Lỗi: Số lượng không được âm. Vui lòng nhập lại!");
            }
        } while (this.soLuong < 0);
    }
    public double tinhThanhTien() {
        return donGia * soLuong;
    }
    public double tinhPhiVanChuyen() {
        return tinhThanhTien() * 0.05;
    }
    public double tinhTongTien() {
        return tinhThanhTien() + tinhPhiVanChuyen();
    }
    public String phanLoaiGia(){
        if (donGia <=50000){
            return "sách giá thấp";
        }
        else if (donGia <=100000){
            return "sách giá trungbinh";
        }
        else if (donGia <=200000){
            return "sách giá cao";
        }
        else {
            return "sách giá đặc biệt";
        }
    }
    public String phanLoaiTonKho(){
        if (soLuong ==0){
            return "hết sách ròi";
        }
        else if (soLuong <=5){
            return "sắp hết ròi cưng ơi";
        }
        else if (soLuong <=20){
            return "còn ít";
        }
        else{
            return"còn nhìuuu, tự tin bán đê";
        }
    }
    public void xuat() {
        System.out.println("\n--- THÔNG TIN SÁCH ---");
        System.out.println("Mã sách: " + maSach);
        System.out.println("Tên sách: " + tenSach);
        System.out.println("Tác giả: " + tacGia);
        System.out.println("Loại sách: "+loaiSach);
        System.out.println("Năm xuất bản: " + namXB);
        System.out.println("Đơn giá: " + donGia + " PHÂN LOẠI: "+phanLoaiGia());
        System.out.println("Số lượng: " + soLuong + " TRONG KHO: "+phanLoaiTonKho());
        System.out.println("Thành tiền: " + tinhThanhTien());
        System.out.println("Phí vận chuyển: " + tinhPhiVanChuyen());
        System.out.println("Tổng tiền nhập: " + tinhTongTien());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bttuan3 sach = new bttuan3();
        sach.nhap(sc);
        sach.xuat();
        sc.close();
    }
}
