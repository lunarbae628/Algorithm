import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for(String c : callings) {
            int idx = map.get(c);
            
            String oppsite = players[idx-1];
            String winner = players[idx];
            
            map.put(oppsite, idx);
            map.put(winner, idx-1);
            
            players[idx] = oppsite;
            players[idx-1] = winner;
        }
        
        return players;
    }
}