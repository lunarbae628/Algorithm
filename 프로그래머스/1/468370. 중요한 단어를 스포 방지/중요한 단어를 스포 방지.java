import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        
        Set<String> importants = new HashSet<>(); 
        Set<String> notimportants = new HashSet<>(); 
        Map<String, List<int[]>> words = new HashMap<>();
        
        int wordStart = 0;
        for(int i = 0; i <= message.length(); i++) {
            if (i == message.length() || message.charAt(i) == ' ') {
                int wordEnd = i - 1;
                words.computeIfAbsent(message.substring(wordStart, i), k -> new ArrayList<>()).add(new int[]{wordStart, wordEnd});
                
                wordStart = i + 1;
            }
        }
        
        for (Map.Entry<String, List<int[]>> entry : words.entrySet()) {
            String word = entry.getKey();
            
            List<int[]> idxs = entry.getValue();
            
            for (int[] idx : idxs) {
                boolean isSpoilerWord = false;
                for (int[] spoiler : spoiler_ranges) {
                    if (idx[0] <= spoiler[1] && spoiler[0] <= idx[1]) {
                        isSpoilerWord = true;
                        break;
                    }
                }
                    
                if (isSpoilerWord) {
                    importants.add(word);
                } else {
                    notimportants.add(word);
                }
            }
            
        }
        
        importants.removeAll(notimportants);

        return importants.size();
    }

}