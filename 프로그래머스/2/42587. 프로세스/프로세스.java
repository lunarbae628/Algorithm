import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> dq = new ArrayDeque<>();
        
        for (int i = 0; i < priorities.length; i++) {
            int[] tmp = {priorities[i], i};
            dq.offerLast(tmp);
        }
        
        int answer = 0;
       
        while(true) {
            int maxP = 0;
    
            for(int[] n : dq) {
                maxP = Math.max(n[0], maxP);
            }
            
            int[] p = dq.poll();
            
            int prior = p[0];
            int idx = p[1];
            
            if(prior == maxP) {
                answer++;
                if(idx == location) {
                    return answer;
                }     
            } else {
                dq.offerLast(p);
            }

        
       }
    }
}