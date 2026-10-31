class Solution {
    int h;
    int w;
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        
        h = park.length;
        w = park[0].length();
        
        int s_x = 0;
        int s_y = 0;
        boolean foundStart = false;
        
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(park[i].charAt(j) == 'S') {
                    s_x = i;
                    s_y = j;
                    foundStart = true;
                    break;
                }
            }
            if(foundStart) break;
        }
        
        for(String r : routes) {
            String direct = r.split(" ")[0];
            int steps = Integer.parseInt(r.split(" ")[1]);
            answer = moveTo(park, direct, steps, s_x, s_y);
            s_x = answer[0];
            s_y = answer[1];
        }
        
        return answer;
    }
    
    private int[] moveTo(String[] park, String direct, int steps, int sx, int sy) {
        
        int dx = 0;
        int dy = 0;
        
        int nx = sx;
        int ny = sy;
        
        switch (direct) {
                case "E" -> {
                    dy = 1;
                }
                case "W" -> {
                    dy = -1;
                }
                case "S" -> {
                    dx = 1;
                }
                case "N" -> {
                    dx = -1;
                }
        }
        
        for(int i = 0; i < steps; i++) {
            nx += dx;
            ny += dy;
            
            if(nx >= 0 && nx < h && ny >= 0 && ny < w && (park[nx].charAt(ny) != 'X')) {
                continue;
            } else {
                return new int[] {sx, sy};
            }
            
        }
        
        return new int[] {nx, ny};
        
    }
}