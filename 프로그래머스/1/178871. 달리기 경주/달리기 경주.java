import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i =0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String call : callings) {
            int idx = map.get(call);
            String tmp = players[idx-1];
            players[idx-1] = call;
            players[idx] = tmp;
            
            map.put(call, idx-1);
            map.put(tmp, idx);
        }
        
        return players;
    }
}