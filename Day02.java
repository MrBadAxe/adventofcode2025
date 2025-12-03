import java.util.List;

public class Day02{
    public static boolean isRepeatedNumber(long n){
        String str = Long.toString(n);
        int len = str.length();
        if(len % 2 == 1){ return false; }
        String a = str.substring(0,(len/2));
        String b = str.substring(len/2);
        return a.equals(b);
    }

    public static boolean isMultiRepeatedNumber(long n){
        String str = Long.toString(n);
        int len = str.length();
        for(int k=1;k<len;k++){
            if(len%k == 0){
                boolean allMatch = true;
                String a = str.substring(0,k);
                for(int j=k;j<len;j+=k){
                    String b = str.substring(j,j+k);
                    if(!a.equals(b)){ allMatch = false; }
                }
                if(allMatch){return true; }
            }
        }
        return false;
    }

    public static String getPart01(List<String> input){
        String list = input.get(0);
        String[] ranges = list.split(",");
        long repeatedNumberTotal = 0;
        for(String range : ranges){
            String[] bounds = range.split("-");
            long lb = Long.parseLong(bounds[0]);
            long ub = Long.parseLong(bounds[1]);
            for(long k = lb; k <= ub; k++){
                if(isRepeatedNumber(k)){
                    repeatedNumberTotal += k;
                }
            }
        }
        return Long.toString(repeatedNumberTotal);
    }
    public static String getPart02(List<String> input){
        String list = input.get(0);
        String[] ranges = list.split(",");
        long repeatedNumberTotal = 0;
        for(String range : ranges){
            String[] bounds = range.split("-");
            long lb = Long.parseLong(bounds[0]);
            long ub = Long.parseLong(bounds[1]);
            for(long k = lb; k <= ub; k++){
                if(isMultiRepeatedNumber(k)){
                    repeatedNumberTotal += k;
                }
            }
        }
        return Long.toString(repeatedNumberTotal);
    }
}