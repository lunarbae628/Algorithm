import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> answerIdxMap = new HashMap<>();
        HashMap<String, HashSet<String>> reported = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++) {
            answerIdxMap.put(id_list[i],i);
            reported.put(id_list[i], new HashSet<>());
        }
        
        for(String r : report) {
            String[] pair = r.split(" ");
            
            HashSet<String> set = reported.get(pair[1]);
            
            set.add(pair[0]);
        }
        
        
        for(HashMap.Entry<String, HashSet<String>> entry : reported.entrySet()) {
            if(entry.getValue().size() >= k) {
                for(String s : entry.getValue()) {
                    answer[answerIdxMap.get(s)]++;
                }
            }
        }
        
        
        return answer;
    }
}