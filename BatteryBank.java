

public class BatteryBank{
    private final String batteries;

    public BatteryBank(String str){
        batteries = str;
    }

    public long calculateMaxJoltage(int maxCount){
        java.util.ArrayList<Integer> joltages = new java.util.ArrayList<>();
        String[] cells = batteries.split("");
        for(String cell : cells){
            joltages.add(Integer.parseInt(cell));
        }
        int index = 0;
        while(joltages.size() > maxCount){
            if(index == joltages.size() - 1 || joltages.get(index) < joltages.get(index+1)){
                joltages.remove(index);
                index = 0;
            }else{
                index++;
            }
            //System.out.println(joltages);
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