class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        int count = 0;
        
        for(int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if(i >= s && i < s + overwrite_string.length()) {
                char oc = overwrite_string.charAt(count);
                answer += oc;
                count++;
            } else {
                answer += c;
            }
        }
        return answer;
        
    }
}