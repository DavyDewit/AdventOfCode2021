public class Tile {
    private int value;
    private boolean checked;

    public Tile(int value){
        this.value = value;
        checked = false;
    }

    public void setChecked(){
        checked=true;
    }

    public int getValue(){
        return value;
    }

    public boolean getChecked(){
        return checked;
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }


}
