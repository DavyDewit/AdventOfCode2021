public class Grid {

    private int [][] grid;

    public Grid(int width, int height){
        grid = new int[height][width];
    }

    public void getGrid() {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                System.out.print(grid[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void fromToGrid(int x,int y, int x2, int y2){
        if(x<=x2 && y==y2){
            for(int i=x;i<=x2;i++){
                for(int j=y;j<=y2;j++){
                    grid[j][i]+=1;
                }
            }
        }
        if(x>=x2 && y==y2){
            for(int i=x;i>=x2;i--){
                for(int j=y;j<=y2;j++){
                    grid[j][i]+=1;
                }
            }
        }
        if(x==x2 && y>=y2){
            for(int i=x;i<=x2;i++){
                for(int j=y;j>=y2;j--){
                    grid[j][i]+=1;
                }
            }
        }
        if(x==x2 && y<=y2){
            for(int i=x;i<=x2;i++){
                for(int j=y;j<=y2;j++){
                    grid[j][i]+=1;
                }
            }
        }

        if(x<x2 && y<y2){
            for(int i=x;i<=x2;i++){
                int j = y2-(x2-i);
                grid[j][i]+=1;
            }
        }
        if(x<x2 && y>y2){
            for(int i=x;i<=x2;i++){
                int j = y2+(x2-i);
                grid[j][i]+=1;
            }
        }
        if(x>x2 && y>y2){
            for(int i=x;i>=x2;i--){
                int j = y-(x-i);
                grid[j][i]+=1;
            }
        }
        if(x>x2 && y<y2){
            for(int i=x;i>=x2;i--){
                int j = y+(x-i);
                grid[j][i]+=1;
            }
        }
    }

    public int getOverlap(){
        int sum=0;
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]>1){
                    sum+=1;
                }
            }
        }
        return sum;
    }
}
