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

    public static String getPart01(List<String> input){
        ArrayList<Present> presents = generatePresentsList(input);
        /*for(Present p : presents){
            System.out.println(p.toString());
        }*/

        int canFitCount = 0;
        //int inconclusive = 0;
        for(int spaceIndex = 30; spaceIndex < input.size(); spaceIndex++){
            String line = input.get(spaceIndex);
            String[] split1 = line.split(":");

            String[] split2 = split1[0].split("x");
            Region r = new Region(Integer.parseInt(split2[0]), Integer.parseInt(split2[1]), '.');
            //System.out.println(r);
            int regionCells = (r.getHeight() * r.getWidth());
            int regionUnpackedPresents = ((r.getHeight() / 3)*(r.getWidth() / 3));
            //System.out.println("cells: " + regionCells + ", 3x3 areas: " + regionUnpackedPresents);

            String[] split3 = split1[1].strip().split("\s+");
            int[] presentCounts = new int[6];
            for(int k=0;k<presentCounts.length;k++){
                presentCounts[k] = Integer.parseInt(split3[k]);
            }
            int totalPresents = 0;
            int totalPresentCells = 0;
            for(int k=0;k<presentCounts.length;k++){
                totalPresents += presentCounts[k];
                totalPresentCells += presents.get(k).sizeInCells() * presentCounts[k];
                //System.out.print(presentCounts[k] + " ");
            }
            //System.out.println(" = " + totalPresents + "(" + totalPresentCells + ")");

            if(totalPresents <= regionUnpackedPresents){
                canFitCount++;
            }else if(totalPresentCells < regionCells){
                //System.out.println("maybe?");
                //inconclusive++;
                /*
                 if we had more presents than there were 3x3 areas in the region,
                 but fewer total present cells than the total region cells,
                 we might have to do some packing
                 but we didn't (inconclusive = 0)
                */
            }
        }
        //System.out.println(inconclusive);
        return Long.toString(canFitCount);
    }
    public static String getPart02(List<String> input){
        return "";
    }

}