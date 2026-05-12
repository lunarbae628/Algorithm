class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int y = wallpaper.length;
        int x = wallpaper[0].length();
        
        int lux = 0;
        int luy = 0;
        int rdx = 0;
        int rdy = 0;
        
        getlux:
        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                char file = wallpaper[i].charAt(j);
                if(file == '#') {
                    answer[0] = i;
                    break getlux;
                }
            }
        }
        
        getluy:
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                char file = wallpaper[j].charAt(i);
                if(file == '#') {
                    answer[1] = i;
                    break getluy;
                }
            }
        }
        
        getrdx:
        for(int i = y-1; i >= 0; i--) {
            for(int j = x-1; j >= 0; j--) {
                char file = wallpaper[i].charAt(j);
                if(file == '#') {
                    answer[2] = i+1;
                    break getrdx;
                }
            }
        }
        
        getrdy:
        for(int i = x-1; i >= 0; i--) {
            for(int j = y-1; j >= 0; j--) {
                char file = wallpaper[j].charAt(i);
                if(file == '#') {
                    answer[3] = i+1;
                    break getrdy;
                }
            }
        }
        

        
        return answer;
    }
}