public class Point3D{
  private final long x;
  private final long y;
  private final long z;

  public Point3D(long x, long y, long z){
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public Point3D(){
    this(0,0,0);
  }

  public long getX(){
    return this.x;
  }

  public long getY(){
    return this.y;
  }

  public long getZ(){
    return this.z;
  }

  public double euclideanDistance(Point3D other){
    double x2 = Math.pow(this.getX() - other.getX(),2);
    double y2 = Math.pow(this.getY() - other.getY(),2);
    double z2 = Math.pow(this.getZ() - other.getZ(),2);
    return Math.sqrt(x2 + y2 + z2);
  }

  @Override
  public boolean equals(Object o){
    if(o == this){ return true; }
    if(!(o instanceof Point)){ return false; }
    Point3D other = (Point3D)o;
    return (this.getX() == other.getX() && this.getY() == other.getY() && this.getZ() == other.getZ());
  }

  public String toString(){
    return "(" + this.getX() + "," + this.getY() + "," + this.getZ() + ")";
  }

  @Override
  public int hashCode(){
    return Long.hashCode(this.getX()) + Long.hashCode(this.getY()) + Long.hashCode(this.getZ());
  }
}
