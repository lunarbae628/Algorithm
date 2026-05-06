class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int[] dy = {1,0,-1,0};
        int[] dx = {0,1,0,-1};
        
        int x = 0, y = 0;
        
        int number = 1;
        int pt=0;
        while(number <= n*n) {
            
            if (x+dx[pt] >= n || y+dy[pt] >= n || x + dx[pt] < 0 || y + dy[pt] < 0 || answer[x + dx[pt]][y + dy[pt]] != 0 ) {
                pt = (pt+1)%4;
            }
            
            answer[x][y] = number++; 
            
            x += dx[pt];
            y += dy[pt];
            
        }
        
        return answer;
    }
}