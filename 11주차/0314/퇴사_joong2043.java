import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[][] arr;
    static int maxP = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // ㅇㅗ늘부터 N+1일째 되는 날 퇴사를 하기 위해 남은 N일 동안 최대한 많은 상담을 하려고 한다.
        // 각각의 상담은 상담을 완료하는데 걸리는 기간 T와 상담을 했을 때 받을 수 있는 금액 P로 이루어져 있다.
        // N이 7인 경우 다음과 같은 상담 일정표를 보자
        //    0  1  2  3  4  5  6
        // Ti 3  5  1  1  2  4  2
        // Pi 10 20 10 20 15 40  200
        // 1일에 잡혀있는 상담은 총 3일, 상담했을 때 받을 수 있는 금액은 10
        // 5일에 잡혀있는 상담은 총 2일이 걸리며 받을 수 있는 금앤은 15

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        StringTokenizer st;

        for (int i = 0; i < n; i++){
            st=new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0,0);

        bw.write(maxP+"");

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int start, int sum, int lastCost){
        // 만약 시작 날짜가 n보다 클 경우는 퇴사 이후에 일이므로 sum에서 lastCost를 뺀 값으로 최대값을 정합니다.
        if (start > n){
            maxP = Math.max(maxP, sum - lastCost);
            return;
            // 만약 시작 날짜가 퇴사 날짜와 일치한다면 sum과 현재 최대값 중에 최대값을 정합니다.
        } else if (start == n) {
            maxP = Math.max(maxP, sum);
            return;
        }

        for (int i = start; i < n; i++) {
            dfs(i + arr[i][0], sum + arr[i][1], arr[i][1]);
        }
    }
}