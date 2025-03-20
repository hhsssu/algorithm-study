class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long num = 0;
        int idx = 0;
        
        for(int i = 0; i < n; i++) {
            num += x;
            answer[idx] = num;
            idx++;
        }
        
        return answer;
    }
}