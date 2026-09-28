import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        int todays = covertToDates(today);
        
        for(String t : terms) {
            String [] term = t.split(" ");
            
            map.put(term[0], Integer.valueOf(term[1]));   
        }
        
        int idx = 0;
        
        for(String p : privacies) {
            String[] pri = p.split(" ");
            int dates = covertToDates(pri[0]);
            int dueDates = map.get(pri[1]) * 28;
            
            if (dates + dueDates <= todays) {
                answer.add(idx+1);
                System.out.println(map.get(pri[1]));
            } 
            idx++;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    
    private int covertToDates(String date) {
        String[] splitDate = date.split("\\.");
        int year = Integer.parseInt(splitDate[0]);
        int month = Integer.parseInt(splitDate[1]);
        int day = Integer.parseInt(splitDate[2]);
        
        return (year * 12 * 28) + (month * 28) + day;
    }
    
}