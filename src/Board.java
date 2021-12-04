import java.util.List;

public class Board {
    private Tile [][] tiles;
    private boolean win;

    public Board(List<String> data){
        tiles = new Tile[5][5];
        int row=0;
        int column = 0;
        for (String line:data) {
            for(String number : line.split(" ")){
                if(!number.equals("")){
                    tiles[row][column]=new Tile(Integer.parseInt(number));
                    column+=1;
                }

            }
            column = 0;
            row+=1;
        }
        win=false;
    }

    public void checkNumber(int number){
        for(int i=0;i<tiles.length;i++){
            for(int j=0;j<tiles[i].length;j++){
                if(tiles[i][j].getValue()==number){
                    tiles[i][j].setChecked();
                }
            }
        }
        checkWin();
    }

    public int getKey(){
        int key = 0;
        for(int i=0;i<tiles.length;i++){
            for(int j=0;j<tiles[i].length;j++){
                if(!tiles[i][j].getChecked()){
                    key+=tiles[i][j].getValue();
                }
            }
        }
        return key;
    }

    public void checkWin(){
        int checked;
        //check Horizontal
        for(int i=0;i< tiles.length;i++){
            checked = 0;
            for(int j=0;j<tiles[i].length;j++){
                if(tiles[i][j].getChecked()){
                    checked +=1;
                }
            }
            if(checked == 5){
                win=true;
            }
        }
        //check Vertical
        for(int i=0;i<tiles[0].length;i++){
            checked = 0;
            for(int j=0;j< tiles.length;j++){
                if(tiles[j][i].getChecked()){
                    checked+=1;
                }
            }
            if(checked==5){
                win=true;
            }
        }
    }

    public boolean isWin() {
        return win;
    }
}
