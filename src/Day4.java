import java.util.ArrayList;
import java.util.List;

public class Day4 {
    public static void main(String[] args) {
        //Preparing data
        List<String> data = Reader.readfile("day4.txt");
        assert data != null;
        int[] bingoValue = transformBingoValues(data.get(0));

        //Building the engine
        BingoGameEngine gameEngine = new BingoGameEngine(data);

        //Build
        List<Integer> keys = new ArrayList<>();
        for (int value : bingoValue) {
            gameEngine.checkAllTheBoardsWithValue(value);
            for(int key : gameEngine.giveKeyValue())
            {
                keys.add(key*value);
            }
        }
        System.out.println(keys);
    }

    public static int[] transformBingoValues(String bingoValues){
        String[] arrayStringBingoValues = bingoValues.split(",");
        int[] convertedValues = new int[arrayStringBingoValues.length];
        int i=0;
        for (String value:arrayStringBingoValues) {
            if(!value.equals("")){
                convertedValues[i]=Integer.parseInt(value);
                i++;
            }
        }
        return convertedValues;
    }
}
