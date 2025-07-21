import java.util.Scanner;

public class DictionaryApp {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary("dictionary.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Ứng dụng Từ điển ---");
            System.out.println("1. Thêm từ mới");
            System.out.println("2. Tra cứu từ");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // clear newline

            switch (choice) {
                case 1:
                    System.out.print("Nhập từ mới: ");
                    String word = scanner.nextLine();
                    System.out.print("Nhập nghĩa: ");
                    String meaning = scanner.nextLine();
                    dictionary.addWord(word, meaning);
                    System.out.println("✔ Đã thêm!");
                    break;

                case 2:
                    System.out.print("Nhập từ cần tra: ");
                    String lookup = scanner.nextLine();
                    String result = dictionary.lookup(lookup);
                    if (result != null) {
                        System.out.println("📝 Nghĩa: " + result);
                    } else {
                        System.out.println("⚠️ Không tìm thấy từ.");
                    }
                    break;

                case 0:
                    System.out.println("Tạm biệt!");
                    return;

                default:
                    System.out.println("⚠️ Lựa chọn không hợp lệ.");
            }
        }
    }
}
