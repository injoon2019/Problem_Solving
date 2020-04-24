//Baekjoon - 15988

import java.io.*;
public class BaekJoon15988 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		long MOD = 1000000009;
		
		long [] dp = new long [1000001];
		
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		
		for(int i=4; i<=1000000; i++) {
                dp[i] = (dp[i-1]%MOD + dp[i-2]%MOD + dp[i-3]%MOD)%MOD ;
        }
		
		
		for(int i=1; i<=T; i++) {
			int n= Integer.parseInt(br.readLine());
			sb.append(dp[n]).append('\n');
			
		}
		
		bw.append(sb);
		bw.flush();
	}	
}