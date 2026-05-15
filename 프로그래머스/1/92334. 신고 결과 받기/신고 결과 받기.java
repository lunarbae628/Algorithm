import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> reported = new HashMap<>();
        Map<String, Integer> answerIdx = new HashMap<>();
        Set<String> uniqueReports = new HashSet<>(Arrays.asList(report));
        
        for (int i = 0; i < id_list.length; i++) {
            reported.put(id_list[i], 0);
            answerIdx.put(id_list[i], i);
        }
        
        for (String r : uniqueReports) {
            String[] tmp = r.split(" ");
            reported.put(tmp[1], reported.get(tmp[1]) + 1);
        } 
        
        for (String r : uniqueReports) {
            String[] parts = r.split(" ");
            String reporter = parts[0];
            String reportedUser = parts[1];
            
            if (reported.get(reportedUser) >= k) {
                int reporterIdx = answerIdx.get(reporter);
                answer[reporterIdx]++;
            }
        }
        
        
        return answer;
    }
}