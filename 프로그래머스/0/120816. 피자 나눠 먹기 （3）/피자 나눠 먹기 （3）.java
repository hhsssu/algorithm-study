class Solution {
    public int solution(int slice, int n) {
        
        int pizza = 0;
        
        // 사람 수 / 피자 조각 수 의 값에서 나머지 값이 있으면 +1을 해준다.
        if(n % slice != 0) {
            pizza = n / slice + 1;
        } else {
            pizza = n / slice;
        }
        
        
        return pizza;
    }
}