import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<ArrayList<int[]>> graph = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<int[]>());
        }
        
        for(int[] r : road) {
            int s = r[0];
            int e = r[1];
            int d = r[2];
            
            graph.get(s).add(new int[] {e, d});
            graph.get(e).add(new int[] {s, d});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int[] dists = new int[N+1];
        int INF = 100_000_000;
        
        for(int i = 0; i < N+1; i++) {
            dists[i] = INF;
        }
        
        dists[1] = 0;
        pq.add(new int[] {1, 0});
        
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            
            if(now[1] > dists[now[0]]) continue;
            
            for(int[] next : graph.get(now[0])) {
                int cost = now[1] + next[1];
                
                if(cost < dists[next[0]]) {
                    dists[next[0]] = cost;
                    pq.add(new int[] {next[0], cost});
                }
                
            }
        }
        
        int answer = 0;
        
        for(int i = 1; i <= N; i++) {
            if(dists[i] <= K) answer++;
        }

        return answer;
    }
}