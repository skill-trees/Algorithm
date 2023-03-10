package 3주차.0117;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] dp=new int[triangle.length][triangle.length];

        dp[0][0]=triangle[0][0];
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<=i;j++){
                int num=0;
                if(j==0){
                    num=dp[i-1][j];
                }else if(j==i){
                    num=dp[i-1][j-1];
                }else{
                    num=Math.max(dp[i-1][j],dp[i-1][j-1]);
                }
                dp[i][j]=num+triangle[i][j];
            }
        }

        for(int i=0;i<triangle.length;i++){
            answer=Math.max(answer,dp[triangle.length-1][i]);
        }

        return answer;
    }
}
