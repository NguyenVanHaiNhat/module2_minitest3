import java.util.Scanner;

public class Main {
    public static final int INITVALUE = 0;

    public static void main(String[] args) {
        NhanVienFulltime nv1 = new NhanVienFulltime("001", "Nhật", "abc@gmail.com", "0945962203", (byte) 18, 200000, 0, 5000000);
        NhanVienFulltime nv2 = new NhanVienFulltime("002", "Đạt", "abc@gmail.com", "0945962203", (byte) 18, 100000, 200000, 5000000);
        NhanVienFulltime nv3 = new NhanVienFulltime("003", "Nhơn", "abc@gmail.com", "0945962203", (byte) 18, 300000, 100000, 5000000);
        NhanVienFulltime nv4 = new NhanVienFulltime("004", "Toàn", "abc@gmail.com", "0945962203", (byte) 18, 600000, 300000, 5000000);
        NhanVienFulltime nv5 = new NhanVienFulltime("005", "Huy", "abc@gmail.com", "0945962203", (byte) 18, 700000, 100000, 5000000);

        NhanVienParttime nv6 = new NhanVienParttime("006", "An", "xyz@gmail.com", (byte) 18, "01202309023", 18);
        NhanVienParttime nv7 = new NhanVienParttime("007", "Bảo", "xyz@gmail.com", (byte) 18, "01202309023", 20);
        NhanVienParttime nv8 = new NhanVienParttime("008", "An", "xyz@gmail.com", (byte) 18, "01202309023", 25);
        NhanVienParttime nv9 = new NhanVienParttime("009", "Huệ", "xyz@gmail.com", (byte) 18, "01202309023", 30);
        NhanVienParttime nv10 = new NhanVienParttime("010", "Nhật", "xyz@gmail.com", (byte) 18, "01202309023", 15);

        NhanVien[] nhanVien = {nv1, nv2, nv3, nv4, nv5, nv6, nv7, nv8, nv9, nv10};

        int choice = -1;
        Scanner input = new Scanner(System.in);

        while (choice != 0) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("1. Tính trung bình lương của nhân viên cả công ty.");
            System.out.println("2. Tính trung bình lương của nhân viên fulltime");
            System.out.println("3. Tính trung bình lương của nhân viên parttime");
            System.out.println("4. Tính tổng lương phải trả cho nhân viên partime");
            System.out.println("5. Đếm số người có mức lương cao hơn mức lương trung bình toàn công ty");
            System.out.println("6. Đếm số nhân viên partime có tên được nhập vào từ bàn phím");
            System.out.println("7. Exit");
            System.out.println("---------------------------------------------------------------");
            System.out.print("nhập lựa chọn của bạn : ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    double avg = avgCost(nhanVien);
                    System.out.println("Trung bình lương của toàn công ty là : " + avg + "VNĐ");
                    break;
                case 2:
                    double avg1 = avgCostFullTime(nhanVien);
                    System.out.println("Trung bình lương của nhân viên full-time là : " + avg1 + "VNĐ");
                    break;
                case 3:
                    double avg2 = avgCostParttime(nhanVien);
                    System.out.println("Trung bình lương của nhân viên part-time là : " + avg2 + "VNĐ");
                    break;
                case 4:
                    double total = totalCostParttime(nhanVien);
                    System.out.println("Tổng tiền của nhân viên part-time là : " + total + "VNĐ");
                    break;
                case 5:
                    int count = countEmployee(nhanVien);
                    System.out.println("số người có mức lương cao hơn mức lương trung bình toàn công ty : " + count);
                    break;
                case 6:
                    System.out.print("Nhập tên nhân viên parttime cần tìm: ");
                    Scanner scanner = new Scanner(System.in);
                    String tenNhanVien = scanner.nextLine();
                    int count2 = numberOfEmployeesByName(nhanVien, tenNhanVien);
                    System.out.println("Số nhân viên part-time cần tìm là : " + count2);
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }

    public static double avgCost(NhanVien[] nhanVien) {
        double avg;
        double total = 0.0;

        for (NhanVien n : nhanVien) {
            total += n.payRoll();
        }
        avg = total / nhanVien.length;
        return avg;
    }

    public static double avgCostFullTime(NhanVien[] nhanVien) {
        double total = 0.0;
        int number = 0;

        for (NhanVien n : nhanVien) {
            if (n instanceof NhanVienFulltime) {
                total += n.payRoll();
                number++;
            }
        }
        return total / number;
    }

    public static double avgCostParttime(NhanVien[] nhanVien) {
        double total = 0.0;
        int number = 0;

        for (NhanVien n : nhanVien) {
            if (n instanceof NhanVienParttime) {
                total += n.payRoll();
                number++;
            }
        }
        return total / number;
    }

    public static double totalCostParttime(NhanVien[] nhanVien) {
        double total = 0.0;

        for (NhanVien n : nhanVien) {
            if (n instanceof NhanVienParttime) {
                total += n.payRoll();
            }
        }
        return total;
    }

    public static int countEmployee(NhanVien[] nhanVien) {
        double avg;
        double total = 0.0;
        int count = INITVALUE;

        for (NhanVien n : nhanVien) {
            total += n.payRoll();
        }
        avg = total / nhanVien.length;

        for (NhanVien n : nhanVien) {
            if (n.payRoll() < avg) {
                count++;
            }
        }
        return count;
    }

    public static int numberOfEmployeesByName(NhanVien[] nhanVien, String tenNhanVien){
        int count = INITVALUE;

        for (NhanVien n : nhanVien){
            if (n instanceof NhanVienParttime && n.getName().equals(tenNhanVien)){
                count++;
            }
        }
        return count;
    }
}