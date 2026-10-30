class Solution {
    
    int answer = 1000000000;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        
        if(answer == 1000000000) {
            return 0;
        }
        
        return answer;
    }
    
    
    public void dfs(String begin, String target, String[] words, int cnt) {
        if(begin.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        if(cnt >= answer) {
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            
            if(!visited[i] && canConvert(begin, words[i])) {
                visited[i] = true;
                
                dfs(words[i], target, words, cnt+1);
                
                visited[i] = false;
            }
            
        }
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