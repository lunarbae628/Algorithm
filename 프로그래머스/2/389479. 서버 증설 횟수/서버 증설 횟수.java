class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[24+k];
        
        for(int i=0; i < 24; i++) {
            int needed = players[i] / m;
            
            if (needed > servers[i]) {
                int add = needed - servers[i];
                System.out.println("i : add" + i + " : " + add);
                answer+= add;
                
                for(int t = i; t < i+k; t++) {
                    servers[t] += add;
                }
            }
            
        }
        return answer;
    }
}