class Solution {
    public int solution(int[][] triangle) {
        
        int h = triangle.length;
        
        for(int i = h-2; i >= 0; i--) {
            for(int j = 0; j < triangle[i].length; j++) {
                
                int now = triangle[i][j];
                
                int left = triangle[i+1][j];
                int right = triangle[i+1][j+1];
                triangle[i][j] = Math.max(now + left, now + right);
            }
        }
        
        return triangle[0][0];
    }
}