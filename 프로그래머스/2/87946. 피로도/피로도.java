class Solution {
    
    int maxCnt = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(k, 0, visited, dungeons);
        
        return maxCnt;
    }
    
    public void dfs(int tired, int cnt, boolean[] visited, int[][] dungeons) {
        maxCnt = Math.max(maxCnt, cnt);
        
        for(int i = 0; i < dungeons.length; i++) {
            
            if(!visited[i] && tired >= dungeons[i][0]) {
                visited[i] = true;
                
                dfs(tired-dungeons[i][1], cnt+1, visited, dungeons);
                
                visited[i] = false;
            }
            
            
        }
        
    }
}