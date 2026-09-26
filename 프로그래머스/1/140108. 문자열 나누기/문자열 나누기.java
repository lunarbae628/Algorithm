import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int iam = 0;
        int you = 0;
        char standardChar = s.charAt(0);
        
        for(int i = 0; i<s.length(); i++) {
            
            if(iam == 0 && you == 0) {
                standardChar = s.charAt(i);
            }
            
            if(standardChar == s.charAt(i)) {
                iam++;
            } else {
                you++;
            }
            
            if(iam == you) {
                answer++;
                iam = 0;
                you = 0;
            }
            
            else if(i == s.length() -1) {
                answer++;
            }
            
         
        }
        
        
        return answer;
    }
}