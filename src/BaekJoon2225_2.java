//Baekjoon - 2225_2
import java.io.*;
public class BaekJoon2225_2 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken =  br.readLine().split(" ");
		int N = Integer.parseInt(strToken[0]);
		int K = Integer.parseInt(strToken[1]);
		
		//dp[K][N] = ���� K���� N�� ��Ÿ���� ����� ��
		long[][] dp = new long[K+1][N+1];
		
		//� ������ �Ѱ��� ��Ÿ���� ����� �ϳ���
		for(int i=0; i<=N; i++) {
			dp[1][i] = 1;
		}
		
		//DP[K][N] = ��(DP[K-1][N-L])
		for(int i=1; i<=K; i++) {
			for(int j=0; j<=N; j++) {
				for(int l=0; l<=j; l++) {
					dp[i][j] += dp[i-1][j-l];
					dp[i][j] %= 1000000000;
				}
			}
		}
		System.out.println(dp[K][N]);
		
	}	
}