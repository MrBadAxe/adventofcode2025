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
        int width = input.get(0).length();
        long[] beams = new long[width];
        for(int k=0;k<width;k++){
            beams[k] = 0;
        }
        for(String str : input){
            long[] newBeams = new long[width];
            for(int k=0;k<width;k++){
                newBeams[k] = 0;
            }
            for(int k=0;k<str.length();k++){
                switch(str.charAt(k)){
                    case 'S':
                        newBeams[k]++;
                        break;
                    case '^':
                        newBeams[k+1] += beams[k];
                        newBeams[k-1] += beams[k];
                        break;
                    case '.':
                    default:
                        newBeams[k] += beams[k];
                }
            }
            beams = newBeams;
        }
        long totalBeams = 0;
        for(int k=0;k<width;k++){
            totalBeams += beams[k];
        }        
        return Long.toString(totalBeams);
    }
}