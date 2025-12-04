import java.util.List;

public class Day03{
    public static String getPart01(List<String> input){
        long totalJoltage = 0;
        for(String str : input){
            BatteryBank bank = new BatteryBank(str);
            long bankJoltage = bank.calculateMaxJoltage(2);
            totalJoltage += bankJoltage;
        }
        return Long.toString(totalJoltage);
    }
    public static String getPart02(List<String> input){
        long totalJoltage = 0;
        for(String str : input){
            BatteryBank bank = new BatteryBank(str);
            long bankJoltage = bank.calculateMaxJoltage(12);
            totalJoltage += bankJoltage;
        }
        return Long.toString(totalJoltage);
    }
}