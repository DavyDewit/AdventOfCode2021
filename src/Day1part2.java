import java.util.ArrayList;
import java.util.List;

public class Day1part2 {
    public static void main(String[] args) {
        List<String> data = Reader.readfile("day1-2.txt");
        List<Integer>newData = new ArrayList<>();
        for(int i=0;i<data.size();i++){
            if(i<data.size()-2){
                int value1 = Integer.parseInt(data.get(i));
                int value2 = Integer.parseInt(data.get(i+1));
                int value3 = Integer.parseInt(data.get(i+2));
                newData.add(value1+value2+value3);
            }
        }
        int increased=0;
        int decreased=0;
        for(int i=0;i<newData.size();i++){
            if(i<newData.size()-1){
                if(newData.get(i)<newData.get(i+1)){
                    increased++;
                }else{
                    decreased++;
                }
            }
        }
        System.out.println("Decreased: " + decreased);
        System.out.println("Increased: " + increased);
    }
}
