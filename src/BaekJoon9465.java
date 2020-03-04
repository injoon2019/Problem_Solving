//Baekjoon - 9465
import java.io.*;
public class BaekJoon9465 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			int n =Integer.parseInt(br.readLine());
			long[][] arr = new long[2][n+1];
			long[][] dp = new long[2][n+1];
			//값들을 입력 받는 과정
			for(int k=0; k<2; k++) {
				String[] strToken = br.readLine().split(" ");
				for(int m=0; m<n; m++) {
					arr[k][m] = Long.parseLong(strToken[m]);
				}
			}	
			
			//dp[i][j]= arr[i][j]를 골랐을때 이때까지 최대값
			dp[0][1]= arr[0][0];
			dp[1][1]= arr[1][0];
			
			//한 열을 뛰어 넘을 수도 있다. 바로 전 열의 대각선, 또는 전전열에서의 대각선 경우를 생각할 수 있다.
			for(int k=2; k<=n;k++) {
				dp[0][k] = Math.max(dp[1][k-1], dp[1][k-2]) + arr[0][k-1];
				dp[1][k] = Math.max(dp[0][k-1], dp[0][k-2]) + arr[1][k-1];
			}
			
			long max = dp[0][0];
						
			for(int k=0; k<2; k++) {
				for(int j=1; j<=n; j++) {
					max = Math.max(max, dp[k][j]);
				}
			}
			System.out.println(max);
		}

	}	
}