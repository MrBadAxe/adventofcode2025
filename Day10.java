import java.util.List;

public class Day10{
    public static String getPart01(List<String> input){
        long totalPresses = 0L;
        for(String str: input){
            FactoryMachine fm = FactoryMachine.parseMachine(str);
            //System.out.println(fm);
            //System.out.println(fm.calculateMinimumPresses());
            totalPresses += fm.calculateMinimumPresses();
        }
        return Long.toString(totalPresses);
    }
    public static String getPart02(List<String> input){
        return "";
    }
}