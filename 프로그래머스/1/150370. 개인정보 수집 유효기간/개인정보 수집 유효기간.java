import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        
        String[] todayList = today.split("\\.");
        
        int todayNum = getDates(todayList);
        
        for(String t : terms) {
            String[] term = t.split(" ");
            map.put(term[0], Integer.parseInt(term[1]) * 28);
        }
        
        for(int i = 0; i<privacies.length; i++) {
            String[] pri = privacies[i].split(" ");
            
            if(todayNum - getDates(pri[0].split("\\.")) >= map.get(pri[1])) {
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
            
    }
    
    private int getDates(String[] date) {
        return (Integer.parseInt(date[0]) * 12 * 28) + (Integer.parseInt(date[1]) * 28) + Integer.parseInt(date[2]);
    }
}