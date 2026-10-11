import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        Map<String, int[]> playsMap = new HashMap<>();
        
        for(int i = 0; i < plays.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            
            int[] play = playsMap.computeIfAbsent(genres[i], k -> new int[plays.length]);
            play[i] = plays[i];
        }
        
        List<String> sortedGenres = new ArrayList<>(map.keySet());
        sortedGenres.sort((a, b) -> map.get(b) - map.get(a));
        
        for(String g : sortedGenres) {
            int[] g_plays = playsMap.get(g);
            
            for(int i=0; i<2; i++) {
                int max_idx = -1;
                int max_plays = -1;
                
                for(int j=0; j<g_plays.length;j++) {
                    if(g_plays[j] > 0 && g_plays[j] > max_plays) {
                        max_plays = g_plays[j];
                        max_idx = j;
                    } 
                }
                
                if (max_idx == -1) {
                    break;
                }
                
                g_plays[max_idx] = -1;
                answer.add(max_idx);
            }
            
            
        }
        
        int[] real_answer = new int[answer.size()];
        
        for(int i =0; i < answer.size(); i++) {
            real_answer[i] = answer.get(i);
        }
        return real_answer;
    }
}