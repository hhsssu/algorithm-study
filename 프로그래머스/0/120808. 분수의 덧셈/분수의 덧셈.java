class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] result = new int[2];
        int denom = denom1 * denom2; // 공통 분모로 계산
        int numer = numer1 * denom2 + numer2 * denom1; // 분자값
        
        // 기약 분수를 위해 최대공약수 계산
        int gcd = gcd(numer, denom);
        
        // 최대공약수로 분자와 분모를 나눔
        numer /= gcd;
        denom /= gcd;

        return new int[]{numer, denom};
    }
    
    // 최대공약수를 구하는 함수 (유클리드 호제법)
    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}