//Baekjoon - 9461
import java.io.*;
public class BaekJoon9461 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[110];
		dp[0]=1;
		dp[1]=1;
		dp[2]=1;
		dp[3]=2;
		dp[4]=2;
		dp[5]=3;
		dp[6]=4;
		dp[7]=5;
		dp[8]=7;
		dp[9]=9;
		for(int i=10; i<110; i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
		
		int N=0;
		for(int i=0; i<T; i++) {
			N = Integer.parseInt(br.readLine());
			System.out.println(dp[N-1]);
		}
	}	
}