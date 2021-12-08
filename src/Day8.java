import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day8 {
    public static void main(String[] args) {
        Decoder decoder = new Decoder();
        List<String> data = Reader.readfile("day8.txt");
        assert data != null;
        partOne(data,decoder);
        partTwo(data,decoder);
    }

    public static void partOne(List<String> data, Decoder decoder){
        int sum = 0;
        for (String line:data){
            decoder.setNewInputOuput(line);
            decoder.reconizeNumbers();
            sum+=decoder.partOne();
        }
        System.out.println(sum);
    }

    public static void partTwo(List<String> data, Decoder decoder){
        long sum = 0;
        for (String line:data) {
            decoder.setNewInputOuput(line);
            decoder.reconizeNumbers();
            decoder.findAllTheNumbers();
            sum += decoder.partTwo();
        }
        System.out.println(sum);


    }
}
