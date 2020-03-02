//Baekjoon - 10844

import java.io.*;
public class BaekJoon10844 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		//dp[i][j] = i 자리 숫자이면서 j로 끝나는 수의 개수
		long [][] dp = new long[101][10];
		
		for(int j=1; j<=9; j++) {
			dp[1][j]=1;
		}
		
		for(int i =1; i<=99; i++) {
			for(int j=0; j<=9; j++) {
				if(j==0 || j==9) {
					if(j==0)
						dp[i+1][j+1] += dp[i][j] % 1000000000;
					if(j==9)
						dp[i+1][j-1] +=dp[i][j]% 1000000000;
				}else {
					dp[i+1][j+1] += dp[i][j]% 1000000000;
					dp[i+1][j-1] += dp[i][j]% 1000000000;
				}
			}
		}
		
		long answer=0;
		for(int k=0; k<=9; k++) {
			answer += dp[N][k]% 1000000000;
		}
		sb.append(answer% 1000000000);
		bw.append(sb);
		bw.flush();
	}	
}