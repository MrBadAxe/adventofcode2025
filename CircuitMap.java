import java.util.HashMap;

public class CircuitMap{
    private HashMap<Point3D,Integer> circuits;
    private int nextNewCircuit;

    public CircuitMap(){
        circuits = new HashMap<>();
        nextNewCircuit = 0;
    }

    public void connect(StringLight sl){
        connect(sl.getA(),sl.getB());
    }
    public void connect(Point3D a, Point3D b){
        if(circuits.containsKey(a) && circuits.containsKey(b)){
            if(circuits.get(a) != circuits.get(b)){
                int src = circuits.get(b);
                int dest = circuits.get(a);
                for(Point3D key : circuits.keySet()){
                    if(circuits.get(key) == src){
                        circuits.put(key,dest);
                    }
                }
            }
        }else if(circuits.containsKey(a) && !circuits.containsKey(b)){
            circuits.put(b,circuits.get(a));
        }else if(!circuits.containsKey(a) && circuits.containsKey(b)){
            circuits.put(a,circuits.get(b));
        }else{
            circuits.put(a,nextNewCircuit);
            circuits.put(b,nextNewCircuit);
            nextNewCircuit++;
        }
    }
    public int[] calculateCircuitSizes(){
        int max = 0;
        for(Point3D key : circuits.keySet()){
            max = Math.max(max,circuits.get(key));
        }
        int[] sizes = new int[max+1];
        for(int k=0;k<max;k++){
            sizes[k] = 0;
        }
        for(Point3D key : circuits.keySet()){
            sizes[circuits.get(key)]++;
        }
        return sizes;
    }
    public int circuitCount(){
        int[] sizes = this.calculateCircuitSizes();
        int z = 0;
        for(int k=0;k<sizes.length;k++){
            if(sizes[k] > 0){
                z++;
            }
        }
        return z;
    }
    public int pointsCount(){
        return circuits.keySet().size();
    }
}