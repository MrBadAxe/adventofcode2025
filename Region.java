public class Region extends CharGrid{
    public Region(int x, int y, char init){
        super(x,y,init);
    }

    public boolean canPlace(Present p, int posRow, int posCol){
        for(int row=0;row<p.getHeight();row++){
            for(int col=0;col<p.getWidth();col++){
                if(!BoundsChecker.checkBounds(new Point(row,col),this) || this.get(posRow+row,posCol+col) != '.'){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean place(Present p, int posRow, int posCol){
        if(!canPlace(p,posRow,posCol)){ return false; }
        for(int row=0;row<p.getHeight();row++){
            for(int col=0;col<p.getWidth();col++){
                if(p.get(posRow+row,posCol+col) == '#'){
                    this.set(posRow+row,posCol+col,'#');
                }
            }
        }
        return true;
    }
}