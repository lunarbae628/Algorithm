class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] field = new int[rows][columns];
        
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < columns; y++) {
                
                field[x][y] = (x * columns + y+1);
                
            }
        }
        
        int ansIdx = 0;
        
        for (int[] q : queries) {
            int x1 = q[0] - 1;
            int y1 = q[1] - 1;
            int x2 = q[2] - 1;
            int y2 = q[3] - 1;
            
            int min = rows * columns;
            
            int temp = field[x1][y1];
            
            // 왼쪽변
            for(int x = x1; x < x2; x++) {
                int rotate = field[x+1][y1];
                field[x][y1] = rotate;
                min = Math.min(min, rotate);
            }
            
            // 아래
            for(int y = y1; y < y2; y++) {
                int rotate = field[x2][y+1];
                field[x2][y] = rotate;
                min = Math.min(min, rotate);
            }
            
            // 오른쪽
            for(int x = x2; x > x1; x--) {
                int rotate = field[x-1][y2];
                field[x][y2] = rotate;
                min = Math.min(min, rotate);
            }
            
            // 위
            for(int y = y2; y > y1; y--) {
                int rotate = field[x1][y-1];
                field[x1][y] = rotate;
                min = Math.min(min, rotate);
            }
            
            field[x1][y1 + 1] = temp;
            
            answer[ansIdx] = Math.min(min, temp);
            ansIdx++;
        }
        
        return answer;
    }
}