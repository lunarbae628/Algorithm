class Solution {
    public int solution(int[][] signals) {
        
        int answer = 0;
        int[] cycle = new int[signals.length];

        for(int i = 0; i < signals.length; i++) {
            for(int j = 0; j < signals[i].length; j++) {
                cycle[i] += signals[i][j];
            }
        }
        
        int lcm = cycle[0];
        
        for (int i = 1; i < cycle.length; i++) {
            lcm = getLCM(lcm, cycle[i]);
        }

        char[] curColour = new char[cycle.length];
        
        for (int t = 0; t <= lcm; t++) {
            
            for (int i = 0; i < cycle.length; i++) {
                int current = t % cycle[i];
                
                int g = signals[i][0];
                int y = signals[i][1];
                int r = signals[i][2];
                
                if(current < g) {
                    curColour[i] = 'G';
                } else if (current < g + y) {
                    curColour[i] = 'Y';
                } else {
                    curColour[i] = 'R';
                }
            }
            
            boolean isYellow = true;
            
            for (int i = 0; i < curColour.length; i++) {
                if (curColour[i] != 'Y') {
                    isYellow = false;
                }
                
            }
            
            if (isYellow) return t+1;
        
        }
        
        return -1;

    }

    public int getLCM(int a, int b) {
        return a / getGCD(a, b) * b;
    }

    public int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }
        
}