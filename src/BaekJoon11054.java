//Baekjoon - 11054

import java.io.*;
public class BaekJoon11054 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] strToken = br.readLine().split(" ");
		int[] arr = new int[N];
		int[][] dp = new int[2][N];
		
		for(int i=0;  i<N; i++) {
			arr[i]= Integer.parseInt(strToken[i]);
		}
		int increasing_max=0;
		int decreasing_max=0;
		int real_max=0;
		boolean turned=false;
		//dp[0][j] = j번째까지 감소하기 시작했을 때 가장 긴 바이토닉 수열의 길이
		//dp[1][j] = j번째까지 증가할 때 가장 긴 바이토닉 수열의 길이
		dp[0][0] = dp[1][0] = 1;
		
		for(int i=0; i<N; i++) {
			increasing_max=0;
			decreasing_max=0;
			turned=false;
			for(int j=0; j<N; j++) {
				if(arr[j] <arr[i]) {
					if(turned==false)
						increasing_max = Math.max(increasing_max, dp[1][j]);
				}
				if(arr[j] > arr[i]) {
					turned=true;
				}
			}
			dp[0][i] = decreasing_max+1;
			dp[1][i] = increasing_max+1;
		}
		
		for(int i=0; i<N; i++) {
			System.out.printf("%d ", dp[i]);
		}
		
		for(int i=0; i<N; i++) {
			real_max = Math.max(real_max, dp[i]);
		}
		
		System.out.println(real_max);
	}	
}