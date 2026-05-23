import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        
        List<int[]> list = new ArrayList<>();
        
        while(left < sequence.length && right < sequence.length) {
            
            if (sum == k) {
                list.add(new int[]{left, right});
            }
            
            if (sum <= k) {
                right++;
                if (right < sequence.length) {
                    sum+= sequence[right];
                }
            } else {
                if (left < sequence.length) {
                    sum-= sequence[left];
                }
                left++;
            }
            
        }
        
        answer = list.get(0);
        
        for (int[] arr : list) {
            if(arr[1] - arr[0] == answer[1] - answer[0]) {
                if(arr[0] < answer[0]) {
                    answer = arr;
                }
            }
            
            if(arr[1] - arr[0] < answer[1] - answer[0]) {
                answer = arr;
            }
        }
        
        
        return answer;
    }
}