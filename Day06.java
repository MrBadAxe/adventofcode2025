import java.util.List;
import java.util.ArrayList;

public class Day06{
    public static String getPart01(List<String> input){
        int countProblems = input.get(0).strip().split("\s+").length;
        long[] problems = new long[countProblems];

        String[] operators = input.get(input.size()-1).strip().split("\s+");
        for(int k=0;k<countProblems;k++){
            if(operators[k].equals("*")){
                problems[k] = 1;
            }else{
                problems[k] = 0;
            }
        }

        for(int k=0;k<input.size()-1;k++){
            String[] nums = input.get(k).strip().split("\s+");
            for(int j=0;j<countProblems;j++){
                if(operators[j].equals("*")){
                    problems[j] *= Long.parseLong(nums[j]);
                }else{
                    problems[j] += Long.parseLong(nums[j]);
                }
            }
        }

        long total = 0;
        for(int k=0;k<countProblems;k++){
            total += problems[k];
        }
        return Long.toString(total);
    }
    public static ArrayList<String> transpose(List<String> input){
        ArrayList<String> z = new ArrayList<>();
        for(int k=input.get(0).length()-1;k>=0;k--){
            String line = "";
            for(int j=0;j<input.size();j++){
                line += input.get(j).charAt(k);
            }
            z.add(line);
        }
        return z;
    }
    public static String getPart02(List<String> input){
        List<String> transposed = transpose(input);
        List<String> problem = new ArrayList<String>();
        long grandTotal = 0;
        for(int k=0;k<transposed.size();k++){
            String line = transposed.get(k);
            if(!line.strip().equals("")){
                problem.add(line);
            }

            if(line.contains("+")){
                long result = 0;
                for(String op : problem){
                    result += Long.parseLong(op.replace("+","").strip());
                }
                problem.clear();
                grandTotal += result;
            }else if(line.contains("*")){
                long result = 1;
                for(String op : problem){
                    result *= Long.parseLong(op.replace("*","").strip());
                }
                problem.clear();
                grandTotal += result;
            }
        }
        return Long.toString(grandTotal);
    }
}