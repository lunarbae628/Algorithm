import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> sQ = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            q.offer(progresses[i]);
            sQ.offer(speeds[i]);
        }
        
        while(!q.isEmpty()) {
            int todayDeploy = 0;
            
            int currentSize = q.size(); 
            for(int i = 0; i < currentSize; i++) {
                int tmpP = q.poll();
                int tmpS = sQ.poll();
            
                tmpP += tmpS;
                
                q.offer(tmpP);
                sQ.offer(tmpS);
            }
            
            boolean fuck = true;
            
            while(fuck) {
                if(!q.isEmpty() && q.peek() >= 100) {
                    q.poll();
                    sQ.poll();
                    todayDeploy++;
                } else {
                    fuck = false;
                }
            }
            
            if(todayDeploy > 0 ) {
                answer.add(todayDeploy);
            }
                    
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}