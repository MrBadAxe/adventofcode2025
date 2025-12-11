public class Segment{
    private Point a;
    private Point b;

    public Segment(Point p1, Point p2){
        a = p1;
        b = p2;
    }
    public Point getA(){
        return a;
    }
    public Point getB(){
        return b;
    }
    public String toString(){
        return a.toString() + "<->" + b.toString();
    }
    public boolean isHorizontalSegment(){
        return a.getX() == b.getX();
    }
    public boolean isVerticalSegment(){
        return a.getY() == b.getY();
    }
    public boolean hasPoint(Point p){
        if(isHorizontalSegment()){
            return  (p.getX() == a.getX()) && 
                    (p.getY() >= Math.min(a.getY(),b.getY())) &&
                    (p.getY() <= Math.max(a.getY(),b.getY()));
        }else if(isVerticalSegment()){
            return  (p.getY() == a.getY()) && 
                    (p.getX() >= Math.min(a.getX(),b.getX())) &&
                    (p.getX() <= Math.max(a.getX(),b.getX()));
        }else{
            return false;
        }
    }
}