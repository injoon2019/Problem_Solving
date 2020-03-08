//Baekjoon - 1912

import java.io.*;
public class BaekJoon1912 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] strToken = br.readLine().split(" ");
		int[] arr = new int[N];
		int[] dp = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(strToken[i]);
		}
		
		dp[0]=arr[0];
		for(int i=1; i<N; i++) {
			if(dp[i-1]<0) {
				 dp[i]=arr[i];
			}
			if(dp[i-1]>=0) {
				dp[i] = dp[i-1]+arr[i];
			}
		}
//		for(int i=1; i<N; i++) {
//			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
//		}
		
		int max = dp[0];
		for(int i=0; i<N; i++) {
			max= Math.max(max, dp[i]);
		}
		System.out.println(max);
	}	
}