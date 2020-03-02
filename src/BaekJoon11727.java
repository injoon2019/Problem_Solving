//Baekjoon - 11727

import java.io.*;
public class BaekJoon11727 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		long [] dp = new long [1001];
		
		dp[1]=1;
		dp[2]=3;
		
		for(int i=3; i<=N; i++) {
                dp[i] = (dp[i-1] + 2*dp[i-2]) % 10007;
        }
		
		sb.append(dp[N]);
		
		bw.append(sb);
		bw.flush();
	}	
}