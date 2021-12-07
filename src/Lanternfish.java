public class Lanternfish {
    private int timer;

    public Lanternfish(int timer){
        this.timer = timer;
    }

    public boolean AnotherDay(){
        timer-=1;
        if(timer==-1){
            timer=6;
            return true;
        }
        return false;
    }

    public Lanternfish breedingTime(){
        return new Lanternfish(8);
    }

}
