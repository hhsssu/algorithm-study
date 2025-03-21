class Solution {
    public int solution(int[] numbers) {
        int answer = 1+2+3+4+5+6+7+8+9;
        for(int i = 0; i < numbers.length; i++) {            
            for(int j = 0; j <= 9; j++) {
                if(numbers[i] == j) {
                    answer -= numbers[i];
                    break;
                }                
            }
        }
        
        return answer;
    }
}