class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int wMax = 0;
        int hMax = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            // 가로의 길이가 세로의 길이보다 작으면 회전(switch)
            if(sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            
            if(sizes[i][0] > wMax) {
                wMax = sizes[i][0];
            }
            
            if(sizes[i][1] > hMax) {
                hMax = sizes[i][1];
            }
        }
        
        answer = wMax * hMax;
        
        return answer;
    }
}