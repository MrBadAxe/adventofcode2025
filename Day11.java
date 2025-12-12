import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Day11{
    private static HashMap<String,ArrayList<String>> generateDeviceMap(List<String> input){
        HashMap<String,ArrayList<String>> z = new HashMap<>();
        for(String line : input){
            String[] split = line.split(":");
            String src = split[0];
            z.put(src, new ArrayList<>());
            String[] dests = split[1].strip().split("\s+");
            for(String dest : dests){
                z.get(src).add(dest);
            }
        }
        return z;
    }
    public static String getPart01(List<String> input){
        HashMap<String,ArrayList<String>> map = generateDeviceMap(input);
        ArrayList<String> traces = new ArrayList<>();
        traces.add("you");
        long totalRoutes = 0;
        while(traces.size() > 0){
            String curr = traces.removeFirst();
            if(curr.equals("out")){
                totalRoutes++;
            }else{
                traces.addAll(map.get(curr));
            }
        }
        return Long.toString(totalRoutes);
    }
    public static String getPart02(List<String> input){
        HashMap<String,ArrayList<String>> map = generateDeviceMap(input);
        HashMap<String,Long> traces = new HashMap<>();
        traces.put("svr0",1L);
        
        long totalRoutes = 0;
        while(traces.size() > 0){
            HashMap<String,Long> newTraces = new HashMap<>();
            for(String src : traces.keySet()){
                String name = src.substring(0,3);
                int flags = src.charAt(3) - '0';

                if(name.equals("dac")){ flags = flags | 0x1; }
                if(name.equals("fft")){ flags = flags | 0x2; }

                for(String dest : map.get(name)){
                        String destFlag = dest + Integer.toString(flags);
                        if(!newTraces.containsKey(destFlag)){
                            newTraces.put(destFlag,0L);
                        }
                        newTraces.put(destFlag, newTraces.get(destFlag) + traces.get(src));
                }
            }

            if(newTraces.containsKey("out3")){
                totalRoutes += newTraces.get("out3");
            }
            newTraces.remove("out0");
            newTraces.remove("out1");
            newTraces.remove("out2");
            newTraces.remove("out3");

            traces = newTraces;
        }
        return Long.toString(totalRoutes);
    }

}