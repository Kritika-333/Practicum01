import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class PersonReader {
    public static void main(String[] args) throws IOException {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
                System.out.printf("%-8s %-12s %-12s %-6s %-5s%n",
                        "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("=======================================================");

                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty()) continue;
                    String[] data = line.split(",", -1);
                    if (data.length != 5) continue;

                    String id = data[0].trim();
                    String first = data[1].trim();
                    String last = data[2].trim();
                    String title = data[3].trim();
                    String yob = data[4].trim();

                    System.out.printf("%-8s %-12s %-12s %-6s %-5s%n",
                            id, first, last, title, yob);
                }
            }
        }
    }
}
