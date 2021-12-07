import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Day7 {
    public static void main(String[] args) {
        String[] data = Reader.readfile("day7.txt").get(0).split(",");
        //String[] data = {"16","1","2","0","4","2","7","1","2","14"};
        OptionalInt optionalHighest = Arrays.stream(data).mapToInt(Integer::parseInt).max();
        int highest=0;
        if(optionalHighest.isPresent()){
            highest = optionalHighest.getAsInt();
        }
        int theLeastFuel=Integer.MAX_VALUE;

        for(int i=1;i<highest;i++){
            int fuel=0;
            for(int j=0;j< data.length;j++){
                int value1= Integer.parseInt(data[j]);
                int value2 = i;
                int helpValue;

                if(value1>value2){
                    helpValue=value1;
                    value1=value2;
                    value2=helpValue;
                }
                int count = 1;
                for(int steps=value1;steps<value2;steps++){
                    fuel+=count;
                    count++;
                }
            }
            if(fuel<theLeastFuel){
                theLeastFuel=fuel;
            }
        }
        System.out.println(theLeastFuel);
    }

}
