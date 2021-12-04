import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day1 {
    public static void main(String[] args) {
        List<String> data = Reader.readfile("day1.txt");
        int increased = 0;
        int decreased = 0;
        for (int i = 0; i < data.size(); i++) {
            if (i != data.size() - 1) {
                int value1 = Integer.parseInt(data.get(i));
                int value2 = Integer.parseInt(data.get(i + 1));
                if (value1 < value2) {
                    increased++;
                } else {
                    decreased++;
                }
            }
        }
        System.out.println("Decreased: " + decreased);
        System.out.println("Increased: " + increased);
    }
}


