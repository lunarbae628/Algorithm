class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int[] goodTime = new int[schedules.length];
        
        for (int i = 0 ; i < schedules.length; i++) {
            int hour = schedules[i] / 100;
            int min = schedules[i] % 100;
            
            int tempMin = min + 10;
            
            if (tempMin >= 60) {
                tempMin = tempMin % 60;
                hour++;
            }
            
            goodTime[i] = hour*100 + tempMin;
        }
        
        for (int j = 0; j <timelogs.length; j++) {
            
            boolean sangpum = true;
            for (int day = 0; day < 7; day++) {
                
                int today = (startday + day - 1) % 7 + 1;
                
                if(today == 6 || today== 7) {
                    continue;
                }
            
                if(timelogs[j][day] > goodTime[j]) {
                    sangpum = false;
                    break;
                }
        
            }
            
            if (sangpum) {
                answer++;
            }
        }

        return answer;
    }
}