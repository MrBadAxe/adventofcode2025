public class Present extends CharGrid{
    public Present(int x, int y, char init){
        super(x,y,init);
    }

    public int sizeInCells(){
        int z = 0;
        for(int row=0;row<HEIGHT;row++){
            for(int col=0;col<WIDTH;col++){
                if(this.get((int)row,(int)col) == '#'){ z++; }
            }
        }
        return z;
    }

    public Present clockwise(){
        Present z = new Present(WIDTH, HEIGHT, '.');
        for(int row=0;row<HEIGHT;row++){
            for(int col=0;col<WIDTH;col++){
                z.set(col,(HEIGHT-1)-row,this.get(row,col));
            }
        }
        return z;
    }

    public Present ccw(){
        Present z = new Present(WIDTH, HEIGHT, '.');
        for(int row=0;row<HEIGHT;row++){
            for(int col=0;col<WIDTH;col++){
                z.set((WIDTH-1)-col,row,this.get(row,col));
            }
        }
        return z;        
    }

    public Present turn180(){
        Present z = new Present(HEIGHT, WIDTH, '.');
        for(int row=0;row<HEIGHT;row++){
            for(int col=0;col<WIDTH;col++){
                z.set((HEIGHT-1)-row,(WIDTH-1)-col,this.get(row,col));
            }
        }
        return z;        
    }

    public Present flipX(){
        Present z = new Present(HEIGHT, WIDTH, '.');
        for(int row=0;row<HEIGHT;row++){
            for(int col=0;col<WIDTH;col++){
                z.set((HEIGHT-1)-row,col,this.get(row,col));
            }
        }
        return z;        
    }

    public Present flipY(){
        Present z = new Present(HEIGHT, WIDTH, '.');
        for(int row=0;row<HEIGHT;row++){
            for(int col=0;col<WIDTH;col++){
                z.set(row,(WIDTH-1)-col,this.get(row,col));
            }
        }
        return z;        
    }

}