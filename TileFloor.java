import java.util.ArrayList;

public class TileFloor extends CharGrid{
    public static final char EMPTY = '.';
    public static final char RED = '#';
    public static final char GREEN = 'X';

    public TileFloor(int x, int y, char init){
        super(x,y,init);
    }

    public void addSegment(Segment s){
        addSegment(s.getA(),s.getB());
    }
    public void addSegment(Point a, Point b){
        if(a.getX() == b.getX()){
            set((int)a.getX(),(int)a.getY(),TileFloor.RED);
            set((int)b.getX(),(int)b.getY(),TileFloor.RED);
            long x = a.getX();
            long yMin = Math.min(a.getY(),b.getY());
            long yMax = Math.max(a.getY(),b.getY());
            for(long k=yMin+1;k<=(yMax-1);k++){
                set((int)x,(int)k,TileFloor.GREEN);
            }
        }else if(a.getY() == b.getY()){
            set((int)a.getX(),(int)a.getY(),TileFloor.RED);
            set((int)b.getX(),(int)b.getY(),TileFloor.RED);
            long y = a.getY();
            long xMin = Math.min(a.getX(),b.getX());
            long xMax = Math.max(a.getX(),b.getX());
            for(long k=xMin+1;k<=(xMax-1);k++){
                set((int)k,(int)y,TileFloor.GREEN);
            }
        }
    }
    public void fill(){
        Point start = new Point();
        for(int row=0;row<HEIGHT;row++){
            for(int col=0;col<WIDTH;col++){
                if(get(row,col) == GREEN && get(row+1,col) == EMPTY){
                    start = new Point(row+1,col);
                    row=HEIGHT;
                    col=WIDTH;
                }
            }
        }
        ArrayList<Point> q = new ArrayList<>();
        q.add(start);
        while(q.size() > 0){
            Point next = q.removeFirst();
            if(get((int)next.getX(),(int)next.getY()) == EMPTY){
                set((int)next.getX(),(int)next.getY(),GREEN);
                ArrayList<Point> neighbors = next.getNeighbors();
                for(Point p : neighbors){
                    if(get((int)p.getX(),(int)p.getY()) == EMPTY){
                        q.add(p);
                    }
                    
                }   
            }
        }
    }
}