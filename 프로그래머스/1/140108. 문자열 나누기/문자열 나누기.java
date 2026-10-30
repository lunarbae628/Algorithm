class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int i = 0;
        
        while(i < s.length()) {
            int s_cnt = 1;
            int n_cnt = 0;
            answer++;
            
            int j = i + 1;
            while(j < s.length()) {
                if(s.charAt(i) == s.charAt(j)) {
                    s_cnt++;
                } else {
                    n_cnt++;
                }
                
                if(s_cnt == n_cnt) {
                    break;
                }
                
                j++;
            }
            
            i = j+1;
            
        }
        
        return answer;
    }
}