import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        
        String[] types = {"RT", "CF", "JM", "AN"};
        Map<Character, Integer> scores = new HashMap<>();
        
        for(String t : types) {
            Character a = t.charAt(0);
            Character b = t.charAt(1);
            scores.put(a, 0);
            scores.put(b, 0);
        }
        
        for(int i = 0; i < survey.length; i++) {
            Character typeA = survey[i].charAt(0);
            Character typeB = survey[i].charAt(1);
            
            int responce = choices[i];
            
            if (responce < 4) {
                int score = 4 - responce;
                scores.put(typeA, scores.get(typeA) + score);
            } else {
                int score = responce - 4;
                scores.put(typeB, scores.get(typeB) + score);
            }
        }
        
        for(String t : types) {
            Character a = t.charAt(0);
            Character b = t.charAt(1);
            
            boolean aBig = a > b;
            
            int as = scores.get(a);
            int bs = scores.get(b);
            
            if (as == bs) {
                if (aBig) {
                    answer.append(b);
                } else {
                    answer.append(a);
                }
            } else {
                if (as > bs) {
                    answer.append(a);
                } else {
                    answer.append(b);
                }
            }

        }
        
        return answer.toString();
    }
}