import java.util.ArrayList;
import java.util.List;

public class Day3 {
    public static void main(String[] args) {
        //part1
        int[] counter  = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        List<String> data = Reader.readfile("day3.txt");
        for (String line:data) {
            for (int i=0;i<line.length();i++) {
                if(line.charAt(i)=='1') {
                    counter[i]++;
                }
            }
        }
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for (int value:counter) {
            if(value>(data.size()/2)){
                gamma.append("1");
                epsilon.append("0");
            }else{
                gamma.append("0");
                epsilon.append("1");
            }
        }
        System.out.println("Gamma: "+gamma+" Epsilon: "+epsilon);
        int product = convertBinaryToDecimal(Long.parseLong(gamma.toString()))*convertBinaryToDecimal(Long.parseLong(epsilon.toString()));
        System.out.println(product);

        //part 2
        char testValue;
        List<List<String>> lists = new ArrayList<>();
        lists.add(data);
        for(int i=0;i<12;i++) {
            List<String> loopList = lists.get(i);
            testValue = getTheTestValue(loopList,i,true);
            List<String> newList = getTheNewList(loopList,testValue,i);
            if(newList.size()==0){
                i=12;
            }else{
                lists.add(newList);
            }
        }
        String oxygen = lists.get(lists.size()-1).get(0);

        List<List<String>> lists2 = new ArrayList<>();
        lists2.add(data);

        for(int i=0;i<12;i++) {
            List<String> loopList = lists2.get(i);
            testValue = getTheTestValue(loopList,i,false);
            List<String> newList = getTheNewList(loopList,testValue,i);
            if(newList.size()==0){
                i=12;
            }else{
                lists2.add(newList);
            }
        }
        String scrubber = lists2.get(lists2.size()-1).get(0);
        System.out.println(oxygen+" "+scrubber);
        int product2 = convertBinaryToDecimal(Long.parseLong(oxygen))*convertBinaryToDecimal(Long.parseLong(scrubber));
        System.out.println(product2);
    }

    public static List<String> getTheNewList(List<String> oldList, char testValue, int index){
        List<String>newList = new ArrayList<>();
        for (String line:oldList) {
            if(line.charAt(index)==testValue){
                newList.add(line);
            }
        }
        return newList;
    }

    public static char getTheTestValue(List<String> list, int index, Boolean test){
        char testValue;
        int count1 = 0;
        int count0 = 0;
        for (String line : list) {
            if (line.charAt(index)=='1'){
                count1+=1;
            }else{
                count0+=1;
            }
        }
        if(test){
            if(count0>count1){
                testValue='0';
            }else{
                testValue='1';
            }
        }else{
            if(count0>count1){
                testValue='1';
            }else{
                testValue='0';
            }
        }

        return testValue;
    }

    public static int convertBinaryToDecimal(long num) {
        int decimalNumber = 0, i = 0;
        long remainder;

        while (num != 0) {
            remainder = num % 10;
            num /= 10;
            decimalNumber += remainder * Math.pow(2, i);
            ++i;
        }
        return decimalNumber;
    }
}
