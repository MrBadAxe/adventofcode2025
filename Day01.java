import java.util.List;

public class Day01{
    public static String getPart01(List<String> input){
        int dial = 50;
        int zeroCount = 0;
        for(String line : input){
            char dir = line.charAt(0);
            int mag = Integer.parseInt(line.substring(1));
            System.out.print(dir + " " + mag + " ");
            if(dir=='L'){
                dial = (dial+100 - mag) % 100;
            }else if(dir=='R'){
                dial = (dial+100 + mag) % 100;
            }
            System.out.println(dial);
            if(dial == 0){zeroCount++;}
        }
        return Integer.toString(zeroCount);
    }
    public static String getPart02(List<String> input){
        int dial = 50;
        int zeroCount = 0;
        for(String line : input){
            char dir = line.charAt(0);
            int mag = Integer.parseInt(line.substring(1));
            System.out.print(dir + " " + mag + " ");
            if(dir=='L'){
                while(mag >= 100){
                    mag -= 100;
                    zeroCount++; System.out.print("+");
                }
                if(dial == 0){
                    dial = (dial-mag)+100;
                }else{
                    dial -= mag;
                    if(dial <= 0){
                        zeroCount++; System.out.print("+");
                    }
                    dial = (dial + 100) % 100;
                }
            }else if(dir=='R'){
                dial += mag;
                while(dial > 99){
                    zeroCount++; System.out.print("+");
                    dial -= 100;
                }
            }
            System.out.println(" " + dial);
        }
        return Integer.toString(zeroCount);
    }
}