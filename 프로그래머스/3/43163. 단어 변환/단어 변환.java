import java.util.*;
class Solution {
    
    static class Node {
        String word;
        int cnt;
        
        Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        Deque<Node> dp = new ArrayDeque<>();
        
        dp.add(new Node(begin, 0));
        
        while(!dp.isEmpty()) {
            Node now = dp.poll();
            
            if(now.word.equals(target)) {
                return now.cnt;
            }
            
            for(int i = 0; i < words.length; i++) {
                
                if(!visited[i] && canConvert(now.word, words[i])) {
                    visited[i] = true;
                    
                    dp.add(new Node(words[i], now.cnt+1));
                }
            }
            
        }
        
        return 0;
    }
    
    public boolean canConvert(String now, String target) {
        int cnt = 0;
        for(int i = 0; i < target.length(); i++) {
            if(now.charAt(i) != target.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}