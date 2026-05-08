class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        int[] field = new int[200];
        
        for (int[] line : lines) {
            int start = line[0];
            int end = line[1];
            
            for (; start < end; start++) {
                field[start+100]++;
            }
        }
        
        for(int num : field) {
            if (num >= 2) {
                answer++;
            }
        }
        
        return answer;
    }
}