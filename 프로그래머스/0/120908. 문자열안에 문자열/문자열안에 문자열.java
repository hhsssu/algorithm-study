class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        out: for(int i = 0; i < str1.length(); i++) {
            for(int j = 0; j < str2.length(); j++) {
                    
                // 만약 i+j가 str1의 길이에 벗어나지 않고,
                // str1의 다음 위치 글자와 str2의 글자가 같다면
                if(i+j < str1.length() && str1.charAt(i+j) == str2.charAt(j)) {
                    // 그리고 str2를 끝까지 다 비교한거라면
                    if(j == str2.length() - 1) {
                        // 같은 문자열이 있다는 것이므로 +1
                        answer += 1;
                        break out; // 하나라도 있으면 끝!
                    } else {
                        continue; // 넘어가서 다음을 비교
                    }
                    
                // 같지 않다면
                } else {
                    break; // 멈춰서 다음 문자 처음부터 다시 비교 (첫번째 for문으로 나감)
                }
            }
        }
        
        if(answer == 0) answer = 2;
        
        return answer;
    }
}