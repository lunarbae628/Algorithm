import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        
        for(int[] s : sizes) {
            Arrays.sort(s);
        }
        
        int maxRow = 0;
        int maxCol = 0;
        
        for(int[] s :sizes) {
            maxRow = Math.max(s[0], maxRow);
            maxCol = Math.max(s[1], maxCol);
        }
        
        return maxRow*maxCol;
    }
}