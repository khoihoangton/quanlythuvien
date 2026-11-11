import java.util.ArrayList;
public class Test_tuan8 {
    public static void main(String[] args) {
        ArrayList<Sach> danhSachSach = new ArrayList<>();
        danhSachSach.add(new Sach("MS01", "Lập trình Java căn bản", "Nguyễn Văn A", 2023, 10));
        danhSachSach.add(new Sach("MS02", "Cấu trúc dữ liệu", "Trần Văn B", 2022, 15));
        System.out.println("--- DANH SÁCH SÁCH TRONG THƯ VIỆN ---");
        for (Sach s : danhSachSach) {
            s.hienThiThongTin();
        }
    }
}