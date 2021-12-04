import java.util.List;

public class Day2part2 {
    public static void main(String[] args) {
        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        List<String> data = Reader.readfile("day2.txt");
        assert data != null;
        for (String direction:data) {
            String [] splittedDirection = direction.split(" ");
            switch(splittedDirection[0]){
                case "forward":
                    horizontal+=Integer.parseInt(splittedDirection[1]);
                    depth+=(aim*Integer.parseInt(splittedDirection[1]));
                    break;
                case "down":
                    aim+=Integer.parseInt(splittedDirection[1]);
                    break;
                case "up":
                    aim-=Integer.parseInt(splittedDirection[1]);
                    break;
            }
        }
        int answer = horizontal * depth;
        System.out.println("key is: "+answer);
    }
}
