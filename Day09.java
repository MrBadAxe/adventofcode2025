import java.util.List;
import java.util.ArrayList;

public class Day09{
    public static ArrayList<Point> generatePointsList(List<String> input){
        ArrayList<Point> z = new ArrayList<>();
        for(String line : input){
            String[] coords = line.split(",");
            z.add(new Point(Long.parseLong(coords[0]),Long.parseLong(coords[1])));
        }
        return z;
    }
    public static long area(Point a, Point b){
        long x = (Math.max(a.getX(),b.getX()) - Math.min(a.getX(),b.getX())) + 1;
        long y = (Math.max(a.getY(),b.getY()) - Math.min(a.getY(),b.getY())) + 1;
        return x*y;
    }
    public static String getPart01(List<String> input){
        ArrayList<Point> points = generatePointsList(input);
        System.out.println(points);
        long maxArea = 0;
        for(int k=0;k<points.size()-1;k++){
            for(int j=k+1;j<points.size();j++){
                Point a = points.get(k);
                Point b = points.get(j);
                System.out.println(a + "<->" + b + " = " + area(a,b));
                maxArea = Math.max(maxArea, area(a,b));
            }
        }
        return Long.toString(maxArea);
    }
    public static boolean checkRegion(TileFloor floor, HashMap<Long,Long> xCompr, HashMap<Long,Long> yCompr, Point a, Point b){
        long xMin = xCompr.get(Math.min(a.getX(),b.getX()));
        long xMax = xCompr.get(Math.max(a.getX(),b.getX()));
        long yMin = yCompr.get(Math.min(a.getY(),b.getY()));
        long yMax = yCompr.get(Math.max(a.getY(),b.getY()));
        for(long row=xMin;row<=xMax;row++){
            for(long col=yMin;col<yMax;col++){
                char cell = floor.get((int)row,(int)col);
                if( cell != TileFloor.RED && cell != TileFloor.GREEN){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static String getPart02(List<String> input){
        return "";
    }
}