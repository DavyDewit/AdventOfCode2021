import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day6 {
    public static void main(String[] args) {
        //Part1
       List<Lanternfish> lanternfishList = preparingData();
        for(int i=0;i<80;i++){
            List<Lanternfish> newFish = new ArrayList<>();
            for (Lanternfish fish:lanternfishList) {
                if(fish.AnotherDay()){
                    newFish.add(fish.breedingTime());
                }
            }
            for(Lanternfish fish:newFish){
                lanternfishList.add(fish);
            }
        }
        System.out.println(lanternfishList.size());
        
        //Part2 (Too much memory usage to reuse code Part 1)
        List<String> lines = Reader.readfile("day6.txt");
        Map<Integer, Long> fishes = Arrays.stream(lines.get(0).split(","))
                .collect(Collectors.groupingBy(Integer::parseInt, Collectors.counting()));
        for(int day = 0; day < 256; day++) {
            long toAdd = fishes.getOrDefault(day % 9, 0L);
            fishes.compute((day + 7) % 9, (k,v) -> v == null ? toAdd : v + toAdd);
            System.out.println("After day(s): " + (day + 1) + " total is: " + fishes.values().stream().mapToLong(i->i).sum());
        }





    }

    public static List<Lanternfish> testData(){
        String[] test = {"3","4","3","1","2"};
        List<Lanternfish>lanternfishList = new ArrayList<>();
        for (String date:test) {
            lanternfishList.add(new Lanternfish(Integer.parseInt(date)));
        }
        return lanternfishList;
    }

    public static List<Lanternfish> preparingData(){
        String[] data = Reader.readfile("day6.txt").get(0).split(",");
        List<Lanternfish>lanternfishList = new ArrayList<>();
        for (String date:data) {
            lanternfishList.add(new Lanternfish(Integer.parseInt(date)));
        }
        return lanternfishList;
    }
}
