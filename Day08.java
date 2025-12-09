import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.HashMap;

public class Day08{
    public static ArrayList<Point3D> generatePointList(List<String> input){
        ArrayList<Point3D> list = new ArrayList<>();
        for(String str : input){
            String[] coords = str.split(",");
            Point3D p = new Point3D(Long.parseLong(coords[0]),Long.parseLong(coords[1]),Long.parseLong(coords[2]));
            list.add(p);
        }
        return list;
    }

    public static TreeSet<StringLight> generateStringLightList(ArrayList<Point3D> points){
        TreeSet<StringLight> z = new TreeSet<>();
        for(int k=0;k<points.size()-1;k++){
            for(int j=k+1;j<points.size();j++){
                Point3D a = points.get(k);
                Point3D b = points.get(j);
                z.add(new StringLight(a,b));
            }
        }
        return z;
    }

    public static ArrayList<StringLight> findNShortest(TreeSet<StringLight> stringLights, int count){
        ArrayList<StringLight> z = new ArrayList<>();
        for(int k=0;k<count;k++){
            z.add(stringLights.pollFirst());
        }
        return z;
    }

    public static HashMap<Point3D,Integer> generateCircuitMap(ArrayList<StringLight> stringLights){
        HashMap<Point3D,Integer> circuits = new HashMap<>();
        int nextNewGroup = 0;
        for(StringLight sl : stringLights){
            //System.out.println(sl.toString());
            Point3D a = sl.getA();
            Point3D b = sl.getB();
            if(circuits.containsKey(a) && circuits.containsKey(b)){
                if(circuits.get(a) != circuits.get(b)){
                    int src = circuits.get(b);
                    int dest = circuits.get(a);
                    //System.out.println(src + "->" + dest);
                    for(Point3D key : circuits.keySet()){
                        if(circuits.get(key) == src){
                            //System.out.println(key.toString());
                            circuits.put(key,dest);
                        }
                    }
                }
            }else if(circuits.containsKey(a) && !circuits.containsKey(b)){
                circuits.put(b,circuits.get(a));
            }else if(!circuits.containsKey(a) && circuits.containsKey(b)){
                circuits.put(a,circuits.get(b));
            }else{
                circuits.put(a,nextNewGroup);
                circuits.put(b,nextNewGroup);
                nextNewGroup++;
            }
            //System.out.println(circuits.toString());
        }
        return circuits;
    }
    public static int[] calculateCircuitSizes(HashMap<Point3D,Integer> circuitMap){
        int circuitMax = 0;
        for(Point3D key : circuitMap.keySet()){
            circuitMax = Math.max(circuitMax,circuitMap.get(key));
        }
        int[] circuitSizes = new int[circuitMax+1];
        for(int k=0;k<circuitMax;k++){
            circuitSizes[k] = 0;
        }
        for(Point3D key : circuitMap.keySet()){
            circuitSizes[circuitMap.get(key)]++;
        }
        return circuitSizes;
    }

    public static long top3Product(int[] operands){
        int[] topIndices = {0,0,0};
        int[] topCircuits = {0,0,0};
        for(int pass=0;pass<3;pass++){
            for(int k=0;k<operands.length;k++){
                if(operands[k] > topCircuits[pass]){
                    topIndices[pass] = k;
                    topCircuits[pass] = operands[k];
                }
            }    
            operands[topIndices[pass]] = -1;
        }
        return (long)(topCircuits[0]*topCircuits[1]*topCircuits[2]);
    }
    
    public static int SHORTEST_COUNT = 1000;

    public static String getPart01(List<String> input){
        ArrayList<Point3D> pointList = generatePointList(input);
        TreeSet<StringLight> stringLights = generateStringLightList(pointList);
        ArrayList<StringLight> shortest = findNShortest(stringLights, SHORTEST_COUNT);
        HashMap<Point3D,Integer> groups = generateCircuitMap(shortest);
        int[] groupSizes = calculateCircuitSizes(groups);
        /*for(int k=0;k<groupSizes.length;k++){
            System.out.print(groupSizes[k] + ", ");pr
        }*/
        return Long.toString(top3Product(groupSizes));
    }
    public static String getPart02(List<String> input){
        return "";
    }
}