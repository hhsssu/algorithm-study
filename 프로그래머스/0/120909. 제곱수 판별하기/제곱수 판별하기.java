class Solution {
    public int solution(int n) {
        int result = 0;
        
        if(n % Math.sqrt(n) == 0) {
            result = 1;
        } else {
            result = 2;
        }
        
        return result;
    }
}