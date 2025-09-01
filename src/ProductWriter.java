import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        ArrayList<String> products = new ArrayList<>();
        boolean done = false;

        while (!done) {
            String id   = SafeInput.getNonZeroLenString(in, "Enter Product ID");
            String name = SafeInput.getNonZeroLenString(in, "Enter Product Name");
            String desc = SafeInput.getNonZeroLenString(in, "Enter Product Description");
            double cost = SafeInput.getDouble(in, "Enter Product Cost");

            String record = id + "," + name + "," + desc + "," + cost;
            products.add(record);

            done = !SafeInput.getYNConfirm(in, "Add another?");
        }

        String fileName = SafeInput.getNonZeroLenString(in, "Enter output file name (with .txt)");
        Path file = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (String p : products) {
                writer.write(p);
                writer.newLine();
            }
        }
        System.out.println("File saved: " + fileName);
    }
}
