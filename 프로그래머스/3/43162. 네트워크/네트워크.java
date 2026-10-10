class Solution {
    public int solution(int n, int[][] computers) {
        int networks = 0;
        
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                networks++;
                dfs(i, computers, visited);
            }
        }
        
        return networks;
    }
    
    public void dfs(int now, int[][] computers, boolean[] visited) {
        visited[now] = true;
        for(int i = 0; i < computers.length; i++) {
            
            if(computers[now][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
        
    }
}