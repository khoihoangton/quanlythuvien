import java.util.ArrayList;
import java.util.Scanner;
import java.time.Year;

public class bttuan5 {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXB;
    private double donGia;
    private int soLuong;
    private String loaiSach;

    // Getter phục vụ cho việc tìm kiếm và thống kê
    public String getMaSach() {
        return maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void nhap(Scanner sc) {
        int namHienTai = Year.now().getValue();
        sc.nextLine(); // Đọc bỏ dòng trống nếu có
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
        return donGia * soLuong; // Đã sửa lỗi thiếu dấu nhân (*)
    }

    public double tinhPhiVanChuyen() {
        return tinhThanhTien() * 0.05;
    }

    public double tinhTongTien() {
        return tinhThanhTien() + tinhPhiVanChuyen();
    }

    public String phanLoaiGia() {
        if (donGia <= 50000) {
            return "sách giá thấp";
        } else if (donGia <= 100000) {
            return "sách giá trung bình";
        } else if (donGia <= 200000) {
            return "sách giá cao";
        } else {
            return "sách giá đặc biệt";
        }
    }

    public String phanLoaiTonKho() {
        if (soLuong == 0) {
            return "hết sách ròi";
        } else if (soLuong <= 5) {
            return "sắp hết ròi cưng ơi";
        } else if (soLuong <= 20) {
            return "còn ít";
        } else {
            return "còn nhìuuu, tự tin bán đê";
        }
    }

    public void xuat() {
        System.out.println("Mã sách: " + maSach + " | Tên: " + tenSach + " | Tác giả: " + tacGia +
                " | Loại: " + loaiSach + " | Năm XB: " + namXB +
                " | Đơn giá: " + donGia + " (" + phanLoaiGia() + ")" +
                " | Số lượng: " + soLuong + " (" + phanLoaiTonKho() + ")" +
                " | Thành tiền: " + tinhThanhTien() +
                " | Phí VC: " + tinhPhiVanChuyen() +
                " | Tổng tiền: " + tinhTongTien());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<bttuan5> danhSachSach = new ArrayList<>();
        int luaChon;

        // Menu lặp hoạt động liên tục (Bài 3)
        do {
            System.out.println("\n=================== MENU QUẢN LÝ THƯ VIỆN ===================");
            System.out.println("1. Nhập danh sách n sách (Bài 1)");
            System.out.println("2. Hiển thị danh sách sách");
            System.out.println("3. Tính tổng số lượng và tổng giá trị sách (Bài 2)");
            System.out.println("4. Tìm sách theo mã (Bài 4)");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = sc.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập số lượng sách (n) cần thêm: ");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println("\n--- Nhập thông tin sách thứ " + (i + 1) + " ---");
                        bttuan5 sach = new bttuan5();
                        sach.nhap(sc);
                        danhSachSach.add(sach);
                    }
                    System.out.println("=> Đã thêm thành công " + n + " cuốn sách vào danh sách!");
                    break;

                case 2:
                    if (danhSachSach.isEmpty()) {
                        System.out.println("=> Thư viện hiện chưa có cuốn sách nào!");
                    } else {
                        System.out.println("\n--- DANH SÁCH SÁCH TRONG THƯ VIỆN ---");
                        for (int i = 0; i < danhSachSach.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            danhSachSach.get(i).xuat();
                        }
                    }
                    break;

                case 3:
                    if (danhSachSach.isEmpty()) {
                        System.out.println("=> Thư viện chưa có dữ liệu để tính toán!");
                    } else {
                        int tongSoLuong = 0;
                        double tongGiaTri = 0;
                        for (bttuan5 s : danhSachSach) {
                            tongSoLuong += s.getSoLuong();
                            tongGiaTri += s.tinhTongTien();
                        }
                        System.out.println("\n--- THỐNG KÊ THƯ VIỆN ---");
                        System.out.println("Tổng số lượng sách trong kho: " + tongSoLuong);
                        System.out.println("Tổng giá trị sách (đã tính phí vận chuyển): " + tongGiaTri);
                    }
                    break;

                case 4:
                    if (danhSachSach.isEmpty()) {
                        System.out.println("=> Thư viện chưa có sách để tìm kiếm!");
                    } else {
                        sc.nextLine(); // Đọc bỏ dòng thừa
                        System.out.print("Nhập mã sách cần tìm: ");
                        String maTimKiem = sc.nextLine();
                        boolean found = false;
                        System.out.println("\n--- KẾT QUẢ TÌM KIẾM ---");
                        for (bttuan5 s : danhSachSach) {
                            if (s.getMaSach().equalsIgnoreCase(maTimKiem)) {
                                s.xuat();
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("=> Không tìm thấy sách có mã: " + maTimKiem);
                        }
                    }
                    break;

                case 0:
                    System.out.println("=> Cảm ơn bạn đã sử dụng chương trình! Tạm biệt.");
                    break;

                default:
                    System.out.println("=> Lựa chọn không hợp lệ! Vui lòng chọn từ 0 đến 4.");
                    break;
            }
        } while (luaChon != 0);

        sc.close();
    }
}