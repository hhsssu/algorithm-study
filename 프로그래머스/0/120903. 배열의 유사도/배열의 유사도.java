class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        
        // 같은 원소의 개수 세기
        for(int one = 0; one < s1.length; one++) {
            for(int two = 0; two < s2.length; two++) {
                if(s1[one].equals(s2[two])) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}