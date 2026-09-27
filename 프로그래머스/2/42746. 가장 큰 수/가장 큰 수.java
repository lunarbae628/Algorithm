import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        
        String[] strs = new String[numbers.length];
        String answer = "";
        int check = 0;
        
        for(int i = 0; i < numbers.length; i++) {
            check+=numbers[i];
            strs[i] = String.valueOf(numbers[i]);
        }
        
        if(check == 0) {
            return "0";
        }
        
        Arrays.sort(strs, (a, b) -> (b+a).compareTo(a+b));
        
        for(String s : strs) {
            answer+=s;
        }
        
        return answer;
        
    }
}