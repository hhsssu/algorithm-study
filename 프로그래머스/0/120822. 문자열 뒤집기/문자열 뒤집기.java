class Solution {
    public String solution(String my_string) {
        // my_string을 charAt로 나누기
        // 역순으로 answer에 담기
        
        String answer = "";
        for(int i = my_string.length() - 1; i >= 0 ; i--) {
            answer += my_string.charAt(i);
        }
        

        return answer;
    }
}