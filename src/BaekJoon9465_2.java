//Baekjoon - 9465_2
import java.io.*;
public class BaekJoon9465_2 {
	
	static int[][] arr;
	static int[][] dp;	
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int C = Integer.parseInt(br.readLine());
			arr = new int[2][C];
			dp = new int[2][C];
			for(int i=0; i<2; i++) {
				String[] strToken = br.readLine().split(" ");
				for(int j=0; j<C; j++) {
					arr[i][j] = Integer.parseInt(strToken[j]);
				}
			}
			//dp[i][j] = arr[i][j]를 고를 때 최대 값
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			
			for(int j=1; j<C; j++) {
				dp[0][j] = dp[1][j-1]+ arr[0][j];
				dp[1][j] = dp[0][j-1]+ arr[1][j];
				if(j>=2) {
					dp[0][j] = Math.max(dp[0][j], dp[0][j-2]+ arr[0][j]);
					dp[0][j] = Math.max(dp[0][j], dp[1][j-2]+ arr[0][j]);
					
					dp[1][j] = Math.max(dp[1][j], dp[0][j-2]+ arr[1][j]);
					dp[1][j] = Math.max(dp[1][j], dp[1][j-2]+ arr[1][j]);
				}
			}
			
			int max = dp[0][0];
			for(int i=0; i<2; i++) {
				for(int j=0; j<C; j++) {
					if(dp[i][j]> max) {
						max = dp[i][j];
					}
				}
			}
			System.out.println(max);
		}
	}	
}