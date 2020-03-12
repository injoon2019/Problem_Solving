//Baekjoon - 2225
import java.io.*;
//https://fbtmdwhd33.tistory.com/80
//https://mygumi.tistory.com/135
public class BaekJoon2225 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken =  br.readLine().split(" ");
		int N = Integer.parseInt(strToken[0]);
		int K = Integer.parseInt(strToken[1]);
		long[][] dp = new long[K+1][N+1];
		
		//dp[k][n] => k개를 더해서 합이 N
		for(int i=0; i<=N; i++) {
			dp[1][i] = 1;
		}
		
		for(int k=1; k<=K; k++) {
			for(int n=0; n<=N; n++ ) {
				for(int l=0; l<=n; l++) {
					dp[k][n] += dp[k-1][n-l] % 1000000000;
				}
				dp[k][n] %=1000000000;
			}
		}
		
		System.out.println(dp[K][N]%1000000000);
	}	
}