class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // n을 7로 나누었을 때 나머지가 0이 아니면 피자 판 + 1
        // 나머지가 0이면 나눈 값 그대로
        // 7보다 작으면 그냥 1
        
        if(n < 7) {
            answer = 1;
        }
        else if (n % 7 != 0) {
            answer = n / 7 + 1;
        }
        else if (n % 7 == 0) {
            answer = n / 7;
        }
        
        return answer;
    }
}