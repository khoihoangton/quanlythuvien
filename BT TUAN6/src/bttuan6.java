import java.util.ArrayList;
import java.util.Scanner;
import java.time.Year;

public class bttuan6 {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXB;
    private double donGia;
    private int soLuong;
    private String loaiSach;

    public String getMaSach() {
        return maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void nhap(Scanner sc) {
        int namHienTai = Year.now().getValue();
        sc.nextLine(); // Đọc bỏ dòng trống
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

    public void xuat() {
        System.out.println("Mã sách: " + maSach + " | Tên: " + tenSach + " | Tác giả: " + tacGia +
                " | Loại: " + loaiSach + " | Năm XB: " + namXB +
                " | Đơn giá: " + donGia + " | Số lượng: " + soLuong +
                " | Tổng tiền: " + tinhTongTien());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<bttuan6> danhSachSach = new ArrayList<>();
        int luaChon;
        do {
            System.out.println("\n=================== MENU QUẢN LÝ THƯ VIỆN (TUẦN 6) ===================");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Tìm sách theo mã");
            System.out.println("4. Xóa sách theo mã");
            System.out.println("5. Sửa thông tin sách theo mã");
            System.out.println("6. Tính tổng số lượng sách");
            System.out.println("7. Tính tổng giá trị sách");
            System.out.println("8. Thoát");
            System.out.print("Nhập lựa chọn của bạn (1-8): ");
            luaChon = sc.nextInt();

            switch (luaChon) {
                case 1: {
                    System.out.print("Nhập số lượng sách cần thêm (n): ");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println("\n--- Nhập thông tin sách thứ " + (i + 1) + " ---");
                        bttuan6 sach = new bttuan6();
                        sach.nhap(sc);
                        danhSachSach.add(sach);
                    }
                    System.out.println("=> Thêm sách thành công!");
                    break;
                }
                case 2: {
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
                }
                case 3: {
                    if (danhSachSach.isEmpty()) {
                        System.out.println("=> Thư viện trống!");
                    } else {
                        sc.nextLine();
                        System.out.print("Nhập mã sách cần tìm: ");
                        String ma = sc.nextLine();
                        boolean found = false;
                        System.out.println("\n--- KẾT QUẢ TÌM KIẾM ---");
                        for (bttuan6 s : danhSachSach) {
                            if (s.getMaSach().equalsIgnoreCase(ma)) {
                                s.xuat();
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("=> Không tìm thấy sách có mã: " + ma);
                        }
                    }
                    break;
                }
                case 4: {
                    if (danhSachSach.isEmpty()) {
                        System.out.println("=> Thư viện trống!");
                    } else {
                        sc.nextLine();
                        System.out.print("Nhập mã sách cần xóa: ");
                        String ma = sc.nextLine();
                        boolean removed = danhSachSach.removeIf(s -> s.getMaSach().equalsIgnoreCase(ma));
                        if (removed) {
                            System.out.println("=> Đã xóa sách thành công!");
                        } else {
                            System.out.println("=> Không tìm thấy mã sách cần xóa!");
                        }
                    }
                    break;
                }
                case 5: {
                    if (danhSachSach.isEmpty()) {
                        System.out.println("=> Thư viện trống!");
                    } else {
                        sc.nextLine();
                        System.out.print("Nhập mã sách cần sửa: ");
                        String ma = sc.nextLine();
                        boolean found = false;
                        for (bttuan6 s : danhSachSach) {
                            if (s.getMaSach().equalsIgnoreCase(ma)) {
                                System.out.println("=> Tìm thấy sách, vui lòng nhập lại thông tin mới:");
                                s.nhap(sc);
                                found = true;
                                System.out.println("=> Cập nhật thông tin thành công!");
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("=> Không tìm thấy mã sách cần sửa!");
                        }
                    }
                    break;
                }
                case 6: {
                    if (danhSachSach.isEmpty()) {
                        System.out.println("=> Thư viện trống!");
                    } else {
                        int tongSL = 0;
                        for (bttuan6 s : danhSachSach) {
                            tongSL += s.getSoLuong();
                        }
                        System.out.println("=> Tổng số lượng tất cả sách trong kho: " + tongSL);
                    }
                    break;
                }
                case 7: {
                    if (danhSachSach.isEmpty()) {
                        System.out.println("=> Thư viện trống!");
                    } else {
                        double tongGT = 0;
                        for (bttuan6 s : danhSachSach) {
                            tongGT += s.tinhTongTien();
                        }
                        System.out.println("=> Tổng giá trị sách trong kho (đã gồm phí VC): " + tongGT);
                    }
                    break;
                }
                case 8: {
                    System.out.println("=> Cảm ơn bạn đã sử dụng chương trình! Tạm biệt.");
                    break;
                }
                default: {
                    System.out.println("=> Lựa chọn không hợp lệ! Vui lòng chọn từ 1 đến 8.");
                    break;
                }
            }
        } while (luaChon != 8);

        sc.close();
    }
}