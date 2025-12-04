

public class BatteryBank{
    private final String batteries;

    public BatteryBank(String str){
        batteries = str;
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

        String z = "";
        for(Integer j : joltages){
            z += Integer.toString(j);
        }
        return Long.parseLong(z);
    }

    public String toString(){
        return this.batteries;
    }
}