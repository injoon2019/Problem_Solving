//Baekjoon - 9095

import java.io.*;
public class BaekJoon9095 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		
		long [] dp = new long [11];
		
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		
		for(int i=4; i<=10; i++) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3] ;
        }
		
		
		for(int i=1; i<=T; i++) {
			int n= Integer.parseInt(br.readLine());
			sb.append(dp[n]).append('\n');
			
		}
		
		bw.append(sb);
		bw.flush();
	}	
}