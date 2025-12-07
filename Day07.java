import java.util.List;
import java.util.HashSet;

public class Day07{
    public static String getPart01(List<String> input){
        int splitCount = 0;
        HashSet<Integer> beams = new HashSet<>();
        for(String str : input){
            HashSet<Integer> newBeams = new HashSet<>();
            for(int k=0;k<str.length();k++){
                switch(str.charAt(k)){
                    case 'S':
                        beams.add(k);
                        break;
                    case '^':
                        if(beams.contains(k)){
                            beams.remove(k);
                            newBeams.add(k-1);
                            newBeams.add(k+1);
                            splitCount++;
                        }
                        break;
                    default:
                }
            }
            beams.addAll(newBeams);
        }
        return Integer.toString(splitCount);
    }
    public static String getPart02(List<String> input){
        return "";
    }
}