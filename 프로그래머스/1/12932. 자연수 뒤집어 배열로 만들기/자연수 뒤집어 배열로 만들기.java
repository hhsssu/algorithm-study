class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        int[] answer = new int[str.length()];
        
        long temp = n;
        int idx = 0;
        while(temp > 0) {
            answer[idx] = (int) (temp % 10);
            temp /= 10;
            idx++;
            
        }
        
        return answer;
    }
}