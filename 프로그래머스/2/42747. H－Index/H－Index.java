import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Integer[] cit = new Integer[citations.length];
        
        for(int i = 0; i<citations.length; i++) {
            cit[i] = citations[i];
        }
        
        Arrays.sort(cit, (o1, o2) -> Integer.compare(o2, o1));
        
        for(int i = 0; i < cit.length; i++) {
            
            int tmp = cit[i];
            int paperCnt = i+1;            
                
            if(tmp >= paperCnt) {
                answer = paperCnt;
            } else {
                break;
            }
        }
        
        return answer;
    }
}