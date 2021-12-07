import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day5 {
    public static void main(String[] args) {
        //exampleRun();
        List<LineCoordinates> coordinatesList = preparingData();
        Grid grid = new Grid(1000,1000);
        coordinatesList.forEach(lc -> grid.fromToGrid(lc.getX(), lc.getY(), lc.getX2(), lc.getY2()));
        System.out.println(grid.getOverlap());
    }
    public static void exampleRun(){
        Grid grid = new Grid(10,10);
        grid.fromToGrid(0,9,5,9);
        grid.fromToGrid(8,0,0,8);
        grid.fromToGrid(9,4,3,4);
        grid.fromToGrid(2,2,2,1);
        grid.fromToGrid(7,0,7,4);
        grid.fromToGrid(6,4,2,0);
        grid.fromToGrid(3,4,1,4);
        grid.fromToGrid(0,9,2,9);
        grid.fromToGrid(0,0,8,8);
        grid.fromToGrid(5,5,8,2);
        grid.getGrid();
        System.out.println(grid.getOverlap());
    }

    private static List<LineCoordinates> preparingData(){
        List<String> data = Reader.readfile("day5.txt");
        List<LineCoordinates> coordinatesList = new ArrayList<>();
        for (String line:data) {
            String[] split = line.split(" -> ");
            String[][] stringCoordinates = new String[2][2];
            stringCoordinates[0]=split[0].split(",");
            stringCoordinates[1]=split[1].split(",");
            int x = Integer.parseInt(stringCoordinates[0][0]);
            int y = Integer.parseInt(stringCoordinates[0][1]);
            int x2 = Integer.parseInt(stringCoordinates[1][0]);
            int y2 = Integer.parseInt(stringCoordinates[1][1]);
            coordinatesList.add(new LineCoordinates(x,y,x2,y2));
        }
        return coordinatesList;
    }
}
