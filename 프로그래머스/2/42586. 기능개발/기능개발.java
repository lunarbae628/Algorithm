import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            int dates = (100 - progresses[i]) / speeds[i];
            
            if((100 - progresses[i]) % speeds[i] > 0) {
                dates++;
            }
            
            q.offer(dates);
        }
        
        
        while(!q.isEmpty()) {
            int p1 = q.poll();
            int todayAnswer = 1;
            
            while(!q.isEmpty()) {
                int p2 = q.peek();
                
                if (p1 >= p2) {
                    todayAnswer++;
                    q.poll();
                } else {
                    break;
                }
            }
            
            answer.add(todayAnswer);
        }
            
            
        return answer.stream().mapToInt(Integer::intValue).toArray();
            
        
        
        
    }
}