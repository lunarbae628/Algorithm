class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 대문자를 소문자로
        answer = new_id.toLowerCase();
        
        StringBuilder sb = new StringBuilder(answer);
        
        // 적절하지 않은 문자 제거
        for(int i = sb.length() - 1; i >= 0; i--) {
            char tmp = sb.charAt(i);
            
            if (!Character.isLowerCase(tmp) &&!Character.isDigit(tmp) && tmp != '-' && tmp != '_' && tmp != '.') {
                sb.deleteCharAt(i);
            }
        }
        
        // 연속 마침표 하나로
        for(int i = sb.length() - 1; i >= 1; i--) {
            if(sb.charAt(i) == sb.charAt(i-1) && sb.charAt(i) == '.') {
                sb.deleteCharAt(i);
            }   
        }
        
        // 첫 or 마지막 마침표 제거
        if(sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        
        if(sb.length() >= 1) {
            if(sb.charAt(sb.length()-1) == '.') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        
        // 빈무자열이면 a
        if(sb.length() == 0) {
            sb.append("a");
        }
        
        // 16자 이상이면 15이후것들 컷
        if(sb.length() >= 16) {
            sb.setLength(15);
        }
        
        if(sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        // 2자 이하면 마지막 문자를 3될때까지 붙힘
        if(sb.length() <= 2) {
            int howFar = 3 - sb.length();
            char tmp = sb.charAt(sb.length() -1);
            
            for(int i = 0; i < howFar; i++) {
                sb.append(tmp);
            }
                
        }
        
        
        System.out.println(sb.toString());
        
        return sb.toString();
    }
}