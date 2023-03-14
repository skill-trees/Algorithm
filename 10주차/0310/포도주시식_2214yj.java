import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int dp[] = new int[n];  // n잔을 마셨을 때 최대 포도주

        for (int i = 0; i < n; i++) {
            if(i == 0) {
                dp[0] = arr[0];
                continue;
            }
            else if(i == 1){
                dp[1] = dp[0] + arr[1];
                continue;
            }else if(i == 2){
                dp[2] = Math.max(dp[1], arr[0] + arr[2]);
                dp[2] = Math.max(dp[2], arr[1] + arr[2]);
                continue;
            }
            // OOX, OXO, XOO인 경우의 최대값을 구한다.
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
            dp[i] = Math.max(dp[i], dp[i - 3] + arr[i - 1] + arr[i]);
        }

        bw.write(dp[n-1]+"");
        bw.close();

    }
}
