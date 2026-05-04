class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] available = {"aya", "ye", "woo", "ma"};

        for (String say:babbling) {
            String tmp = say;
            
            for(String word:available) {
                tmp = tmp.replace(word," ");
            }
            
            tmp = tmp.replace(" ","");
            
            if (tmp.length() == 0) {
                answer++;
            }
            
        }
        
        return answer;
    }
}