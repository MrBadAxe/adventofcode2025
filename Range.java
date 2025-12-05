public class Range{
  private final long lower;
  private final long upper;

  public Range(long lb, long ub){
    this.lower = lb;
    this.upper = ub;
  }

  public long getLower(){
    return this.lower;
  }
  public long getUpper(){
    return this.upper;
  }

  public boolean inRange(long n){
    return n >= this.lower && n <= this.upper;
  }

  public boolean overlaps(Range other){
    return !(other.getLower() > this.getUpper() || other.getUpper() < this.getLower());
  }

  public boolean isAdjacentTo(Range other){
    if(this.overlaps(other)){
      return false;
    }else if(this.getLower() > other.getLower()){
      return other.getUpper()+1==this.getLower();
    }else{
      return this.getUpper()+1==other.getLower();
    }
  }

  public Range merge(Range other){
    if(!(this.overlaps(other) || this.isAdjacentTo(other))){
      return null;
    }else{
      return new Range(Math.min(this.getLower(),other.getLower()),Math.max(this.getUpper(),other.getUpper()));
    }
  }

  public String toString(){
    return "[" + this.getLower() + "," + this.getUpper() + "]";
  }

  public long size(){
    return (this.getUpper() - this.getLower()) + 1;
  }
}
