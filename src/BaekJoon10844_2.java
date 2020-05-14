//Baekjoon - 10844_2

import java.io.*;
public class BaekJoon10844_2 {
	static long[][] dp;
	static int mod = 1000000000;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		dp = new long[101][11];
		
		//i자리 숫자이면서 j로 끝나는 숫자의 수 
		for(int j=1; j<=9; j++) {
			dp[1][j] = 1;
		}
		
		for(int i=2; i<=N; i++) {
			dp[i][0] = dp[i-1][1];
			for(int j=1; j<=9; j++) {
				dp[i][j] = (dp[i-1][j-1]+ dp[i-1][j+1])%mod;
			}
		}
		long sum = 0;
		for(int i=0; i<10; i++) {
			sum+=dp[N][i];
		}
		System.out.println(sum%mod);
	}	
}