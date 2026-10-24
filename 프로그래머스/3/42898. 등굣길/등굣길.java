class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[n+1][m+1];
        
        for(int[] p : puddles) {
            dp[p[1]][p[0]] = -1;
        }
        
        dp[1][1] = 1;
        
        for(int i = 1; i <= n; i++) {
            
            for(int j = 1; j <= m; j++) {
                
                if((i == 1 && j == 1) || dp[i][j] == -1) continue;
                
                int fromTop = 0;
                int fromLeft = 0;
                
                if(i - 1 >= 1 && dp[i-1][j] != -1) {
                    fromTop = dp[i-1][j];
                }
                
                if(j-1 >= 1 && dp[i][j-1] != -1) {
                    fromLeft = dp[i][j-1];
                }
                
                dp[i][j] = (fromTop + fromLeft) % 1000000007;
                
            }
        }
        
        return dp[n][m];
    }
}