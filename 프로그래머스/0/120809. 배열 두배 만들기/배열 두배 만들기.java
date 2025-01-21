class Solution {
    public int[] solution(int[] numbers) {
        int[] doubleNums = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            doubleNums[i] = numbers[i]*2;
        }
        
        return doubleNums;
    }
}