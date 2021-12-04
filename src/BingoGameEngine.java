import java.util.ArrayList;
import java.util.List;

public class BingoGameEngine {
    private List<Board> boards;

    public BingoGameEngine(List<String> data){
        List<List<String>> sortedData = prepareTheData(data);
        boards = buildBoards(sortedData);
    }

    public void checkAllTheBoardsWithValue(int value){
        for (Board board:boards) {
            board.checkNumber(value);
        }
    }

    public List<Integer> giveKeyValue(){
        int key=0;
        List<Integer> keys = new ArrayList<>();
        List<Board> boardDelete = new ArrayList<>();
        for(Board board:boards){
            if(board.isWin()){
                key = board.getKey();
                boardDelete.add(board);
                keys.add(key);
            }
        }
        for (Board board:boardDelete) {
            boards.remove(board);
        }
        return keys;
    }


    private List<List<String>> prepareTheData(List<String> data){
        List<List<String>> sortedData = new ArrayList<>();
        data.remove(0);
        data.remove(0);
        List<String> listValue = new ArrayList<>();
        for (String line: data) {
            if(!line.equals("")){
                listValue.add(line);
            }else{
                sortedData.add(listValue);
                listValue = new ArrayList<>();
            }
        }
        return sortedData;
    }

    private List<Board> buildBoards(List<List<String>> sortedData){
        List<Board> boards = new ArrayList<>();
        for (List<String> data:sortedData) {
            boards.add(new Board(data));
        }
        return boards;
    }
}
