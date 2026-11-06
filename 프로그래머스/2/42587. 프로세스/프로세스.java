import java.util.*;

class Solution {
    
    static class Process {
        int p;
        int l;
        
        public Process (int p, int l) {
            this.p = p;
            this.l = l;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<Process> dq = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++) {
            dq.add(new Process(priorities[i], i));
        }
        
        while(!dq.isEmpty()) {
            int max_p = 0;
            for(Process p : dq) {
                max_p = Math.max(max_p, p.p);
            }
            
            Process now = dq.pollFirst();

            if(now.p == max_p) { 
                answer++;
                if(now.l == location) {
                    break;
                }
            } else {
                dq.offerLast(now);
            }
            
        }
        return answer;
    }
}