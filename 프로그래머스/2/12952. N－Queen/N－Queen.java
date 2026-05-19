class Solution {
    int answer = 0;
    int[] board;
    int n;
    public int solution(int n) {
        this.n = n;
        board = new int[n];
        
        bt(0);
        return answer;
    }
    
    private void bt(int row) {
        if (row == n) {
            answer++;
            return;
        }
        
        for(int col = 0; col < n; col++) {
            if(canLocate(row, col)) {
                board[row] = col;
                bt(row+1);
            }
        }
        
    }
    
    private boolean canLocate(int row, int col) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = board[prevRow];
            if (prevCol == col) {
                return false;
            }
            
            if (Math.abs(col - prevCol) == Math.abs(row - prevRow)) {
                return false;
            }
            
        }
        return true;
    }
}