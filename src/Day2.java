import java.util.List;

public class Day2 {
    public static void main(String[] args) {
        int horizontal = 0;
        int depth = 0;
        List<String> data = Reader.readfile("day2.txt");
        assert data != null;
        for (String direction:data) {
            String [] splittedDirection = direction.split(" ");
            switch(splittedDirection[0]){
                case "forward":
                    horizontal+=Integer.parseInt(splittedDirection[1]);
                    break;
                case "down":
                    depth+=Integer.parseInt(splittedDirection[1]);
                    break;
                case "up":
                    depth-=Integer.parseInt(splittedDirection[1]);
                    break;
            }
        }
        int answer = horizontal * depth;
        System.out.println("key is: "+answer);
    }
}
