import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        if(s.length() % 2 > 0) {
            return 0;
        }
        
        String expand = s + s;
        
        for(int i = 0; i < s.length(); i++) {
            String rotated = expand.substring(i, i+s.length());
            
            if(isValid(rotated)) {
                answer++;
            }
        }
        
        
        return answer;
    }
    
    private boolean isValid(String target) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            
            if(c == '{' || c == '(' || c == '[') {
                stack.offerLast(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    char out = stack.pollLast();
                    
                    if(out == '(' && c != ')') return false;
                    if(out == '[' && c != ']') return false;
                    if(out == '{' && c != '}') return false;
                }
            }
        }
        
        return true;
    }
}