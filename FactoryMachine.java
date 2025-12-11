public class FactoryMachine{
    private int lightCount;
    private int panelLights;
    private int[] buttons;
    private int[] joltages;

    public static FactoryMachine parseMachine(String input){
        String[] split = input.split("\s");
        String splitLights = split[0].substring(1,split[0].length()-1);
        String[] splitButtons = new String[split.length-2];
        for(int k=0;k<split.length-2;k++){
            //System.out.println(k+1 + ": " + split[k+1]);
            splitButtons[k] = split[k+1];
        }
        String splitJoltages = split[split.length-1];

        FactoryMachine z = new FactoryMachine(splitLights.length(), parseLights(splitLights), parseButtons(splitLights.length(),splitButtons), parseJoltages(splitJoltages));
        return z;
    }

    private static int parseLights(String lights){
        //System.out.println(lights);
        int z = 0;
        for(int k=0;k<lights.length();k++){
            z *= 2;
            if(lights.charAt(k) == '#'){
                z+= 1;
            }
        }
        //System.out.println(z);
        return z;
    }

    private static int[] parseButtons(int count, String[] b){
        //System.out.println(count);
        //System.out.println(String.join(",",b));
        int[] z = new int[b.length];
        for(int k=0;k<b.length;k++){
            z[k] = collapseWiringSchematic(count, b[k]);
        }
        return z;
    }

    private static int collapseWiringSchematic(int count, String s){
        int z = 0;
        //System.out.println(s);
        String inner = s.substring(1, s.length()-1);
        String[] split = inner.split(",");
        for(int k=0;k<split.length;k++){
            z += (1 << ((count-1) - Integer.parseInt(split[k])));
        }
        return z;
    }

    private static int[] parseJoltages(String j){
        String[] split = j.substring(1,j.length()-1).split(",");
        int[] z = new int[split.length];
        for(int k=0;k<z.length;k++){
            z[k] = Integer.parseInt(split[k]);
        }
        return z;
    }

    private FactoryMachine(int count, int l, int[] b, int[] j){
        lightCount = count;
        panelLights = l;
        buttons = b;
        joltages = j;
    }

    public String toString(){
        String z = "";

        z += lightCount + " ";

        z += "[" + panelLights + "] ";
        
        for(int k=0;k<buttons.length;k++){
            z += (k == 0 ? "(" : ",");
            z += buttons[k];
        }
        z += ") ";

        for(int k=0;k<joltages.length;k++){
            z += (k == 0 ? "{" : ",");
            z += joltages[k];
        }
        z += "}";

        return z;
    }

    public int calculateMinimumPresses(){
        int z = Integer.MAX_VALUE;
        for(int k=0;k<Math.pow(2,buttons.length);k++){
            int result = 0;
            int onCount = 0;
            for(int j=0;j<buttons.length;j++){
                if(((k >> j) & 1) == 1){
                    onCount++;
                    result = result ^ buttons[buttons.length-(j+1)];
                }
            }
            //System.out.println(k + ": " + result + "(" + onCount + ")");
            if(result == panelLights){
                z = Math.min(z,onCount);
            }
        }
        //System.out.println(z);
        return z;
    }
}