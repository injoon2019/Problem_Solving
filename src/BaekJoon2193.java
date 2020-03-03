//Baekjoon - 2193
import java.io.*;
public class BaekJoon2193 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		//dp[i][j] = i는 0또는 1로 맨 끝자리 수, j는 길이 
		long[][] dp = new long[2][N+1];
		dp[0][1] = 0;
		dp[1][1] = 1;
		
		for(int i=2; i<=N; i++) {
			dp[0][i] += dp[0][i-1];
			dp[0][i] +=dp[1][i-1];
			dp[1][i] +=dp[0][i-1];
		}
		long answer = dp[0][N]+dp[1][N];
		sb.append(answer);
		
		bw.append(sb);
		bw.flush();
	}	
}