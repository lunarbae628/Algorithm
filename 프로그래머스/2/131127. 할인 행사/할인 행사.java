import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> windowMap = new HashMap<>();
        
        for(int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for(int i = 0; i < 10; i++) {
            windowMap.put(discount[i], windowMap.getOrDefault(discount[i], 0) + 1);
        }
        
        int answer = 0;

        if(canBuy(wantMap, windowMap)) answer++;
        
        for(int i = 10; i < discount.length; i++) {
            String prev = discount[i-10];
            String next = discount[i];

            if(windowMap.get(prev) == 1) {
                windowMap.remove(prev);
            } else {
                windowMap.put(prev, windowMap.get(prev) -1);
            }
                
            windowMap.put(next, windowMap.getOrDefault(next, 0) + 1);
            
            if(canBuy(wantMap, windowMap)) {
                answer++;
            } 
        }
        
        
        return answer;
    }
    
    private boolean canBuy(Map<String, Integer> wantMap, Map<String, Integer> windowMap) {
        for(String key : wantMap.keySet()) {
            
            if(!windowMap.containsKey(key)) return false;
            
            if(windowMap.get(key) < wantMap.get(key)) {
                return false;
            }
        }
        return true;
    }
}