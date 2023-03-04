import java.util.Stack;

class Solution {
    // number의 값이 10^6임으로 완전 탐색은 시간초과
    // 자리를 바꾸는 것은 안됨.
    // 앞에서 부터 큰수가 남으면 됨.
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>(); // 반환할 값
        char current; // 현재값과
        char next; // 다음값

        for (int i = 0; i < number.length(); i++) {
            next = number.charAt(i);
            while (!stack.isEmpty()) {
                current = stack.pop();
                if (current < next && k > 0) {
                    k--;
                } else {
                    stack.add(current);
                    break;
                }
            }
            stack.add(next);
        }

//         while(k > 0){
//             stack.pop();
//             k--;
//         }


        StringBuilder answer = new StringBuilder();
        for (char i : stack){
            answer.append(i);
        }
        return answer.toString();
    }
}