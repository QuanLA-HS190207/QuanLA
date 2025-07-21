import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private final Map<String, String> words = new HashMap<>();
    private final String filePath;

    public Dictionary(String filePath) {
        this.filePath = filePath;
        loadFromFile();
    }

    // Thêm từ mới
    public void addWord(String word, String meaning) {
        words.put(word.toLowerCase(), meaning);
        saveToFile();
    }

    // Tra từ
    public String lookup(String word) {
        return words.get(word.toLowerCase());
    }

    // Lưu vào file
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : words.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu từ điển: " + e.getMessage());
        }
    }

    // Tải từ file lên
    private void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    words.put(parts[0].toLowerCase(), parts[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc từ điển: " + e.getMessage());
        }
    }
}

