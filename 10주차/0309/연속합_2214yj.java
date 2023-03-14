import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Integer.MIN_VALUE;
        int sum = 0;    // left부터 right까지의 arr의 합 (left < i <= right)

        int left = -1;
        for (int right = 0; right < n; right++) {
            if (sum > 0) { // 양수인 경우
                if (arr[right] < -1 * sum) { // 연속된 수를 더하는 것이 좋지 않은 경우
                    left = right;
                    sum = 0;
                } else {
                    sum += arr[right];
                    max = Math.max(max, sum);
                }
            } else {  // sum이 0 미만인 경우
                // sum = arr[right]인 상황을 만들고 최댓값을 갱신한다.
                left = right - 1;
                sum = arr[right];
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}

