//Baekjoon - 2225_2
import java.io.*;
public class BaekJoon2225_3 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken =  br.readLine().split(" ");
		int N = Integer.parseInt(strToken[0]);
		int K = Integer.parseInt(strToken[1]);
		
		//dp[K][N]= K개로 N 만드는 방법의 수 
		long[][] dp = new long[K+1][N+1];
		
		for(int n=0; n<=N; n++) {
			dp[1][n] =1;
		}
		
		for(int k=2; k<=K; k++) {
			for(int n=0; n<=N; n++) {
				for(int l=0; l<=n; l++) {
					dp[k][n] += dp[k-1][n-l];
					dp[k][n] %= 1000000000;
				}
			}
		}
		
		System.out.println(dp[K][N]);
	}	
}