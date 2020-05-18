//Baekjoon - 1699_2

import java.io.*;
public class BaekJoon1699_2 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[100001];
		
		for(int i=1; i<=N; i++) {
			dp[i] = i;
			for(int j=1; j*j<=i; j++) {
				if(dp[i] > dp[i-j*j]+1) {
					dp[i] = dp[i-j*j]+1;
				}
			}
		}
		System.out.println(dp[N]);
	}
}