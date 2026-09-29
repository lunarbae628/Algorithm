class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[][] phone = new int[4][3];
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                phone[i][j] = j + 1 + (3) * i;
            }
            phone[3][0] = -2;
            phone[3][2] = -1;
        }
        
        int[] l_location = {3, 0};
        int[] r_location = {3, 2};
        
        for(int n : numbers) {
            if(n == 1 || n == 4 || n == 7) {
                l_location[0] = (n-1)/3;
                l_location[1] = 0;
                answer+="L";
            } else if(n == 3 || n == 6 || n == 9) {
                r_location[0] = (n-3)/3;
                r_location[1] = 2;
                answer+="R";
            } else {
                int[] centerNumLocation = new int[2];
                if(n==0) {
                    centerNumLocation[0] = 3;
                    centerNumLocation[1] = 1;
                } else {
                    centerNumLocation[0] = (n-2)/3;
                    centerNumLocation[1] = 1;
                }
                
                int distanceFromL = Math.abs(l_location[0] - centerNumLocation[0]) + Math.abs(l_location[1] - centerNumLocation[1]);
                int distanceFromR = Math.abs(r_location[0] - centerNumLocation[0]) + Math.abs(r_location[1] - centerNumLocation[1]);
                
                if(distanceFromL < distanceFromR) {
                    l_location[0] = centerNumLocation[0];
                    l_location[1] = centerNumLocation[1];
                    answer+="L";
                } else if(distanceFromL > distanceFromR) {
                    r_location[0] = centerNumLocation[0];
                    r_location[1] = centerNumLocation[1];
                    answer+="R";
                } else {
                    if(hand.equals("right")) {
                        r_location[0] = centerNumLocation[0];
                        r_location[1] = centerNumLocation[1];
                        answer+="R";
                    } else {
                        l_location[0] = centerNumLocation[0];
                        l_location[1] = centerNumLocation[1];
                        answer+="L";
                    }
                    
                }
                
            }
            
            
        }
        
        
        
        return answer;
    }
}