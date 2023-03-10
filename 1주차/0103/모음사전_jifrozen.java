class Solution {
    static int count = 0;
    static int answer = 0;

    public void DFS(String[] word_list, String sb, String word) {
        if (sb.length() >= 5) {
            return;
        }
        for (int i = 0; i < 5; i++) {
            String s = sb + word_list[i];
            count++;
            if (s.equals(word)) {
                answer = count;
                return;
            }
            ;
            DFS(word_list, s, word);
        }
    }

    public int solution(String word) {
        String[] word_list = { "A", "E", "I", "O", "U" };
        DFS(word_list, "", word);
        return answer;
    }
}