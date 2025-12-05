import java.util.List;
import java.util.ArrayList;

public class Day05{
    public static ArrayList<Range> generateRangeList(List<String> input){
        ArrayList<Range> z = new ArrayList<>();
        for(int index=0; !input.get(index).equals(""); index++){
            String line = input.get(index);
            String[] bounds = line.split("-");
            z.add(new Range(Long.parseLong(bounds[0]),Long.parseLong(bounds[1])));
        }
        return z;
    }
    public static String getPart01(List<String> input){
        int countFresh = 0;
        ArrayList<Range> ranges = generateRangeList(input);
        for(int index = ranges.size()+1; index < input.size(); index++){
            long ingredient = Long.parseLong(input.get(index));
            boolean fresh = false;
            for(Range r : ranges){
                fresh = fresh | r.inRange(ingredient);
            }
            if(fresh){
                countFresh++;
            }
        }
        return Integer.toString(countFresh);
    }

    public static ArrayList<Range> combineRanges(ArrayList<Range> ranges){
        for(int k=0;k<ranges.size()-1;k++){
            for(int j=k+1;j<ranges.size();j++){
                if(ranges.get(k).overlaps(ranges.get(j)) || ranges.get(k).isAdjacentTo(ranges.get(j))){
                    Range kj = ranges.get(k).merge(ranges.get(j));
                    ranges.remove(j);
                    ranges.remove(k);
                    ranges.add(kj);
                    k=0;
                    j=1;
                }
            }
        }
        return ranges;
    }
    public static String getPart02(List<String> input){
        ArrayList<Range> ranges = generateRangeList(input);
        ranges = combineRanges(ranges);
        long totalFresh = 0;
        for(Range r : ranges){
            totalFresh += r.size();
        }
        return Long.toString(totalFresh);
    }
}