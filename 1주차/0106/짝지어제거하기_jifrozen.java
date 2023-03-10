import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        stack.push(ch[0]);
        for (int i = 1; i < s.length(); i++) {
            if (stack.size() == 0) {
                stack.push(ch[i]);
                continue;
            }
            char c = stack.pop();
            if (ch[i] != c) {
                stack.add(c);
                stack.add(ch[i]);
            }
        }

        if (stack.size() == 0) {
            answer = 1;
        }

        return answer;
    }
}
