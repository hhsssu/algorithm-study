class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int big = b;
        int small = a;
        
        if(a > b) {
            big = a;
            small = b;
        }
        
        for(int i = small; i <= big; i++) {
            answer += i;
        }
        
        return answer;
    }
}