class Solution {
    public int solution(int n) {
        int root = (int)Math.sqrt(n);
        double doubleRoot = Math.sqrt(n);
        int result = 1;
        
        if((double)root - doubleRoot < 0) {
            result = 2;
        }        
        
        
        return result;
    }
}