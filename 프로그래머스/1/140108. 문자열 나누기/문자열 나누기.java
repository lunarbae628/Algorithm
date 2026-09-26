import java.util.*;

class Solution {
    public int solution(String s) {
        ArrayList<String> answer = new ArrayList<>();
        
        int iam = 0;
        int you = 0;
        int standardIdx = 0;
        char standardChar = s.charAt(0);
        
        for(int i = 0; i<s.length(); i++) {
            
            if(iam == 0 && you == 0) {
                standardIdx = i;
                standardChar = s.charAt(i);
            }
            
            if(standardChar == s.charAt(i)) {
                iam++;
            } else {
                you++;
            }
            
            if(iam == you) {
                answer.add(s.substring(standardIdx, i+1));
                iam = 0;
                you = 0;
            }
            
            else if(i == s.length() -1) {
                answer.add(s.substring(standardIdx, i+1));
            }
            
         
        }
        
        for(String fuck : answer) {
            System.out.println(fuck);
        }
        
        
        return answer.size();
    }
}