//Baekjoon - 2579

import java.io.*;
public class BaekJoon2579 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[][] dp = new int[2][N];
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		int tmp;
		//맨 마지막 계단을 꼭 밟아야한다고 하니 처음부터 뒤집어서 처음껄 밟고 시작하자
		for(int i=0; i<N/2; i++) {
			tmp = arr[i];
			arr[i] = arr[N-i-1];
			arr[N-i-1] = tmp;
		}
		
		dp[0][0] =arr[0];
		dp[1][0] = arr[0];
		if(N>=2)
			dp[1][1]= dp[0][0]+arr[1];
		//dp[1][i] = 그 직전 것을 밟은 경우이므로 dp[0][i-1] + arr[i]
		//dp[0][i] = 그 직전 것을 안밟았으므로 두가지 옵션이 생긴다. 따라서 Math.max(dp[0][i-2], dp[1][i-2]) + arr[i]
		for(int i=2; i<N; i++) {
			dp[0][i] = Math.max(dp[0][i-2], dp[1][i-2]) +arr[i];
			dp[1][i] = dp[0][i-1] +arr[i];
		}
		int max = dp[0][0];
		for(int i=0; i<N; i++) {
			max = Math.max(max, dp[0][i]);
			max = Math.max(max,  dp[1][i]);
		}

		System.out.println(max);
	}	
}