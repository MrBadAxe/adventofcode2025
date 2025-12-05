import java.util.ArrayList;

public class PaperRollGrid extends CharGrid{
    public PaperRollGrid(int x, int y, char init){
        super(x,y,init);
    }

    public ArrayList<Point> findMovableRolls(){
        ArrayList<Point> totalRolls = new ArrayList<>();
        for(int row=0;row<this.getHeight();row++){
            for(int col=0;col<this.getWidth();col++){
                if(this.get(row,col) == '@'){
                    Point cell = new Point(row,col);
                    ArrayList<Point> neighbors = cell.getNeighbors(true);
                    int filled = 0;
                    for(Point neighbor : neighbors){
                        if(BoundsChecker.checkBounds(neighbor,this) && this.get((int)neighbor.getX(),(int)neighbor.getY()) == '@'){
                            filled++;
                        }
                    }
                    if(filled < 4){
                        System.out.println(cell);
                        totalRolls.add(cell);
                    }
                }
            }
        }
        return totalRolls;
    }
    public PaperRollGrid clone(){
        PaperRollGrid z = new PaperRollGrid(this.getHeight(),this.getWidth(),'.');
        for(int row=0;row<HEIGHT;row++){
          for(int col=0;col<WIDTH;col++){
            z.set(row,col,this.get(row,col));
          }
        }
        return z;
      }
    public PaperRollGrid moveRolls(ArrayList<Point> rolls){
        PaperRollGrid z = this.clone();
        for(Point p : rolls){
            z.set((int)p.getX(),(int)p.getY(),'.');
        }
        return z;
    }
}