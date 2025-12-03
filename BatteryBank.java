

public class BatteryBank{
    private final int BATT_COUNT;
    private final int[] batteries;

    public static int[] parseBatteryBank(String str){
        int[] z = new int[str.length()];
        for(int k=0;k<z.length;k++){
            z[k] = str.charAt(k) - '0';
        }
        return z;
    }

    public BatteryBank(String str){
        BATT_COUNT = str.length();
        batteries = parseBatteryBank(str);
    }

    public int calculateMaxJoltage(){
        int maxJoltage = 0;
        for(int k=0;k<BATT_COUNT-1;k++){
            for(int j=k+1;j<BATT_COUNT;j++){
                int joltage = batteries[k] * 10 + batteries[j];
                maxJoltage = java.lang.Math.max(maxJoltage,joltage);
            }
        }
        return maxJoltage;
    }

    public String toString(){
        String z = "";
        for(int k=0;k<BATT_COUNT;k++){
            z += batteries[k];
        }
        return z;
    }
}