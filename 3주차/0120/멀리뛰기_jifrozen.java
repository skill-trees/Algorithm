class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[2001];
        // 1
        // 1 1 / 2
        // 1 1 1 / 2 1 / 1 2
        // 1 1 1 1 / 1 1 2 / 2 1 1/ 1 2 1/ 2 2
        // 1 1 1 1 1

        dp[1] = 1 % 1234567;
        dp[2] = 2 % 1234567;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] % 1234567 + dp[i - 2] % 1234567;
        }

        answer = dp[n] % 1234567;
        return answer % 1234567;
    }
}