import java.util.List;

public class Day04{
    private static PaperRollGrid generatePaperRollGrid(List<String> input){
        PaperRollGrid grid = new PaperRollGrid(input.size(), input.get(0).length(), '.');
        for(int row=0;row<grid.getHeight();row++){
            String line = input.get(row);
            for(int col=0;col<grid.getWidth();col++){
                grid.set(row,col,line.charAt(col));
            }
        }
        return grid;
    }
    public static String getPart01(List<String> input){
        PaperRollGrid grid = generatePaperRollGrid(input);
        return Integer.toString(grid.findMovableRolls().size());
    }
    public static String getPart02(List<String> input){
        int totalMovable = 0;
        PaperRollGrid grid = generatePaperRollGrid(input);
        while(grid.findMovableRolls().size() > 0){
            totalMovable += grid.findMovableRolls().size();
            grid = grid.moveRolls(grid.findMovableRolls());
        }
        return Integer.toString(totalMovable);
    }
}