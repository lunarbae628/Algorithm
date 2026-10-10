import java.util.*;
class Solution {
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    
    static class Node {
        int x;
        int y;
        int dist;
        
        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while(!dq.isEmpty()) {
            Node now = dq.poll();
            
            if(now.x == n-1 && now.y == m-1) {
                return now.dist;
            }
            
            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == false) {
                    if(maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        dq.add(new Node(nx, ny, now.dist+1));
                    }
                }
            }
        }
        
        return -1;
        
    }
}