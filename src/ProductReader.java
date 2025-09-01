import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ProductReader {
    public static void main(String[] args) throws IOException {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
                System.out.printf("%-8s %-14s %-32s %-8s%n",
                        "ID#", "Name", "Description", "Cost");
                System.out.println("======================================================================");

                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty()) continue;
                    String[] data = line.split(",", -1);
                    if (data.length != 4) continue;

                    String id   = data[0].trim();
                    String name = data[1].trim();
                    String desc = data[2].trim();
                    double cost = Double.parseDouble(data[3].trim());

                    System.out.printf("%-8s %-14s %-32s %-8.1f%n",
                            id, name, desc, cost);
                }
            }
        }
    }
}
