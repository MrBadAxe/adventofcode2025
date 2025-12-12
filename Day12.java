import java.util.ArrayList;
import java.util.List;

public class Day12{
    public static ArrayList<Present> generatePresentsList(List<String> input){
        ArrayList<Present> z = new ArrayList<>();
        for(int presentIndex=0;presentIndex<6;presentIndex++){
            Present p = new Present(3, 3, '.');
            for(int row=0;row<3;row++){
                String line = input.get((presentIndex * 5) + row + 1);
                for(int col=0;col<3;col++){
                    p.set(row,col,line.charAt(col));
                }
            }
            z.add(p);
        }
        return z;
    }
    public static ArrayList<Region> generateRegionsList(List<String> input){
        int spaceCount = input.size()-30;
        ArrayList<Region> z = new ArrayList<>();
        for(int spaceIndex = 0; spaceIndex < spaceCount; spaceIndex++){
            String line = input.get(spaceIndex + 30);
            String[] split1 = line.split(":");
            String[] split2 = split1[0].split("x");
            Region ps = new Region(Integer.parseInt(split2[0]), Integer.parseInt(split2[1]), '.');
            z.add(ps);
        }
        return z;
    }
    public static int[][] generatePresentCountList(List<String> input){
        int spaceCount = input.size()-30;
        int[][] z = new int[spaceCount][6];
        for(int spaceIndex = 0; spaceIndex < spaceCount; spaceIndex++){
            String line = input.get(spaceIndex + 30);
            String[] split1 = line.split(":");
            String[] split2 = split1[1].strip().split("\s+");
            for(int k=0;k<split2.length;k++){
                z[spaceIndex][k] = Integer.parseInt(split2[k]);
            }
        }
        return z;
    }


    public static String getPart01(List<String> input){
        ArrayList<Present> presents = generatePresentsList(input);
        for(Present p : presents){
            System.out.println(p.toString());
        }

        ArrayList<Region> regions = generateRegionsList(input);
        for(Region r : regions){
            System.out.println(r.toString());
        }
        
        int[][] presentCounts = generatePresentCountList(input);
        for(int k=0;k<presentCounts.length;k++){
            for(int j=0;j<presentCounts[k].length;j++){
                System.out.print(presentCounts[k][j] + " ");
            }
            System.out.print("\n");
        }
        

        return "";
    }
    public static String getPart02(List<String> input){
        return "";
    }

}