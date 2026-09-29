import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        Map<String, Integer> discntMap = new HashMap<>();
        for(int i = 0; i < 10; i++) {
            discntMap.put(discount[i], discntMap.getOrDefault(discount[i], 0) + 1);
        }
        
        if(matchWantAndDiscount(map, discntMap)) {
            answer++;
        }
        
        // 슬라이딩 윈도우 연습하셈
        for(int i = 1; i <= discount.length-10; i++) {
            
            String outItem = discount[i-1];
            
            if(discntMap.get(outItem) == 1) {
                discntMap.remove(outItem);
            } else {
                discntMap.put(outItem, discntMap.get(outItem) - 1);
            }
            
            String inItem = discount[i+9];
            discntMap.put(inItem, discntMap.getOrDefault(inItem, 0) + 1);
            
            if(matchWantAndDiscount(map, discntMap)) {
                answer++;
            }
        }
            
        return answer;
    }
    
    private boolean matchWantAndDiscount(Map<String, Integer> wantMap, Map<String, Integer> discntMap) {
        
        for(String key : wantMap.keySet()) {
            
            if(wantMap.get(key) > discntMap.getOrDefault(key, 0)) {
                return false;
            }
        }
        return true;
    }
}