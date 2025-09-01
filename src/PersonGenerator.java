import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        ArrayList<String> people = new ArrayList<>();
        boolean done = false;

        while (!done) {
            String id = SafeInput.getNonZeroLenString(in, "Enter ID");
            String first = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String last = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(in, "Enter Title (Mr., Ms., etc.)");
            int yob = SafeInput.getInt(in, "Enter Year of Birth");

            String record = id + "," + first + "," + last + "," + title + "," + yob;
            people.add(record);

            done = !SafeInput.getYNConfirm(in, "Add another?");
        }

        String fileName = SafeInput.getNonZeroLenString(in, "Enter output file name (with .txt)");

        Path file = Paths.get(fileName);
        BufferedWriter writer = Files.newBufferedWriter(file);

        for (String p : people) {
            writer.write(p);
            writer.newLine();
        }
        writer.close();
        System.out.println("File saved: " + fileName);
    }
}
