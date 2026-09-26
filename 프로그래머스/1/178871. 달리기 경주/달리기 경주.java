import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for(String c : callings) {
            int idx = map.get(c);
            String tmp = players[idx - 1];
            
            players[idx-1] = c;
            players[idx] = tmp;
            
            map.put(c, idx-1);
            map.put(tmp, idx);
        
        }
        
        return players;
        
        
    }
}