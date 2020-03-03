//Baekjoon - 11057

import java.io.*;
public class BaekJoon11057 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		//dp[i][j] = i 자리 숫자이면서 j로 끝나는 수의 개수
		long [][] dp = new long[1001][10];
		int[] index= {10,9,8,7,6,5,4,3,2,1};
		
		for(int j=0; j<=9; j++) {
			dp[1][j]=1;
		}
		
		for(int i=2; i<=1000; i++) {
			for(int j=0; j<=9; j++) {
				for(int k=j; k<=9; k++) {
					dp[i][k] += dp[i-1][j] %10007;
				}
			}
		}
		
		long answer=0;
		for(int k=0; k<=9; k++) {
			answer += dp[N][k]% 10007;
		}
		sb.append(answer% 10007);
		bw.append(sb);
		bw.flush();
	}	
}