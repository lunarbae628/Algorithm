import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        String[] todays = today.split("\\.");
        
        int todayInt = toDays(todays);
        
        Map<String, Integer> termMap = new HashMap<>();
        
        for(int i = 0; i < terms.length; i++) {
            String termKind = terms[i].substring(0,1);
            Integer termExpire = Integer.parseInt(terms[i].substring(2)) * 28;
            System.out.println(termKind + termExpire);
            termMap.put(termKind, termExpire);
        }
        
        for(int j = 0; j < privacies.length; j++) {
            String[] privaciesDate = privacies[j].substring(0,10).split("\\.");
            int privaciesDateInt = toDays(privaciesDate);
            
            String privaciesKind = privacies[j].substring(11);
            
            if(termMap.get(privaciesKind) + privaciesDateInt <= todayInt) {
                answer.add(j+1);
            }

        } 

        return answer.stream().
            mapToInt(Integer::intValue)
            .toArray();
    }
    
    
    
    
    
    public int toDays(String[] strDay) {
        return (Integer.parseInt(strDay[0]) * 12 * 28) + (Integer.parseInt(strDay[1]) * 28) + Integer.parseInt(strDay[2]);
    }
}