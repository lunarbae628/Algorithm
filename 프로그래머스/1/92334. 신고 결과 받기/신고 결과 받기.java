import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> idxMap = new HashMap<>();
        Map<String, HashSet<String>> reported = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++) {
            idxMap.put(id_list[i], i);
            reported.put(id_list[i], new HashSet<>());
        }
        
        for(String r : report) {
            String[] list = r.split(" ");
            
            String reporter = list[0];
            String reportee = list[1];
            
            reported.get(reportee).add(reporter);
        }
        
        for(String key : reported.keySet()) {
            
            if(reported.get(key).size() >= k) {
                for(String reporter : reported.get(key)) {
                    answer[idxMap.get(reporter)]++;
                }
            }
            
        }
        return answer;
    }
}