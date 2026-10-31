import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();
        
        for(String t : terms) {
            String[] tmp = t.split(" ");
            
            int termMonthToDays = Integer.parseInt(tmp[1]) * 28;
            
            termsMap.put(tmp[0], termMonthToDays);
        }
        
        int todayDays = convertToDays(today);
        
        for(int i = 0; i < privacies.length; i++) {
            String[] p_tmp = privacies[i].split(" ");
            
            int privacy_date = convertToDays(p_tmp[0]);
            String kind = p_tmp[1];
            
            int terms_dates = termsMap.get(kind);
            
            if(privacy_date + terms_dates <= todayDays) {
                answer.add(i+1);
            }
            
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int convertToDays(String ymd) {
        String[] tmp = ymd.split("\\.");
        
        return Integer.parseInt(tmp[0]) * 12 * 28 + Integer.parseInt(tmp[1]) * 28 + Integer.parseInt(tmp[2]);
    }
}