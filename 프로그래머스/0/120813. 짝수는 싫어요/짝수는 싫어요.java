class Solution {
    public int[] solution(int n) {
        
        int num = 0;
        if(n % 2 != 0) {
            num = n / 2 + 1;
        } else {
            num = n / 2;
        }
        
        int[] answer = new int[num];
        
        // 배열 0부터 시작
        int i = 0;
        
        // answer 배열에 홀수만 담기
        for(int j = 1; j <= n; j++) {
            if(j % 2 != 0) {
                answer[i] = j;
                i++;
            }
        }
            
        return answer;
    }
}