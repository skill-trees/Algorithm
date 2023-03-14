import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 자리수 N을 입력받는다.
        long[][] dp = new long[N + 1][10];    // n자리수의 n번째 값이 i일 때 가능한 계단 수의 개수
        long count = 0;

        for (int n = 1; n < N + 1; n++) {
            for (int i = 0; i < 10; i++) {    // N의 자리수가 i일때
                if (n == 1) {
                    dp[n][i] = 1;
                } else if (i == 0) {
                    dp[n][i] = dp[n - 1][i + 1] % 1000000000;
                } else if (i == 9) {
                    dp[n][i] = dp[n - 1][i - 1] % 1000000000;
                } else {
                    dp[n][i] = (dp[n - 1][i - 1] + dp[n - 1][i + 1]) % 1000000000;
                }

            }
            // N의 자리수가 0인 경우 제외
            count = Arrays.stream(dp[N]).sum() - dp[N][0];
        }
        System.out.println(count % 1000000000);

    }

}


