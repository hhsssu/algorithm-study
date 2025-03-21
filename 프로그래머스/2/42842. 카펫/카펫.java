class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int tiles = brown + yellow;
        // 제곱근 구하기
        int root = (int) Math.sqrt(tiles);
        
        for(int i = root; i > 0; i--) {
            if(tiles % i == 0) {
                if(yellow == (i - 2) * (tiles / i - 2)) {
                    answer[0] = Math.max(i, tiles/i);
                    answer[1] = Math.min(i, tiles/i);
                    break;
                }
            }
        }
        
        
        return answer;
    }
}