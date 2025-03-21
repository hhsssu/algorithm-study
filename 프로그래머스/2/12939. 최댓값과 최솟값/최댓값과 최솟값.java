class Solution {
    public String solution(String s) {
        String answer = "";
        String[] numbers = s.split(" ");
        int max = -10000;
        int min = 10000;
        
        for(int i = 0; i < numbers.length; i++) {
            int a = Integer.parseInt(numbers[i]);
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        
        answer = min + " " + max;
        return answer;
    }
}