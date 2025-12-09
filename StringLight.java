public class StringLight implements Comparable<StringLight>{
    private final Point3D a;
    private final Point3D b;
    private final double dist;

    public StringLight(Point3D p1, Point3D p2){
        a = p1;
        b = p2;
        dist = a.euclideanDistance(b);
    }

    public Point3D getA(){
        return this.a;
    }
    public Point3D getB(){
        return this.b;
    }
    public double length(){
        return this.dist;
    }

    public int compareTo(StringLight other){
        return (int)Math.signum(this.length() - other.length());
    }

    public String toString(){
        return a.toString() + "<=>" + b.toString();
    }
}
