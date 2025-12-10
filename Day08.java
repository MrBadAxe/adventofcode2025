import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;

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

    public static CircuitMap generateCircuitMap(ArrayList<StringLight> stringLights){
        CircuitMap circuits = new CircuitMap();
        for(StringLight sl : stringLights){
            circuits.connect(sl);
        }
        return circuits;
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
        CircuitMap groups = generateCircuitMap(shortest);
        int[] groupSizes = groups.calculateCircuitSizes();
        return Long.toString(top3Product(groupSizes));
    }
    public static String getPart02(List<String> input){
        ArrayList<Point3D> pointList = generatePointList(input);
        TreeSet<StringLight> stringLights = generateStringLightList(pointList);
        ArrayList<StringLight> shortest = findNShortest(stringLights, stringLights.size());
        CircuitMap map = new CircuitMap();
        int index = 0;
        for(index = 0; map.pointsCount() < pointList.size() || map.circuitCount() != 1 ; index++){
            map.connect(shortest.get(index));
        }
        StringLight last = shortest.get(index-1);

        return Long.toString(last.getA().getX() * last.getB().getX());
    }
}