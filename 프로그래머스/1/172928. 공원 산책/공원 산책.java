class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        int[] start = new int[2];
        
        int h = park.length;
        int w = park[0].length();
        
        int[][] park2 = new int[h][w];
        
        for(int i = 0; i < park.length; i++) {
            for(int idx=0; idx<park[0].length(); idx++) {
                if(park[i].charAt(idx) == 'S') {
                    start[0] = i;
                    start[1] = idx;
                }
                
                if(park[i].charAt(idx) == 'X') {
                    park2[i][idx] = 1;
                }
            }
        }
        
        for(String route: routes) {
            String[] parts = route.split(" ");
            char dir = parts[0].charAt(0);
            int num = Integer.parseInt(parts[1]);
            
            int dx = 0;
            int dy = 0;
            
            if (dir == 'E') {
                dx = 1;
            }

            if (dir == 'W') {
                dx = -1;
            }

            if (dir == 'S') {
                dy = 1;
            }

            if (dir == 'N') {
                dy = -1;
            }
            
            boolean canMove = true;
            
            for(int j=1; j<=num; j++) {
                int nextX = start[1] + j * dx;
                int nextY = start[0] + j * dy;
                
                if (nextX < 0 || nextX >= w || nextY < 0 || nextY >= h) {
                    canMove = false;
                    break;
                }
                
                if (park2[nextY][nextX] == 1) {
                    canMove = false;
                    break;
                }
            }
            
            if (canMove) {
                start[0] = start[0] + dy * num;
                start[1] = start[1] + dx * num;
            }
        }
        

        return start;
    }
}