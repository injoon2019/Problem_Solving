//Baekjoon - 11052

import java.io.*;
public class BaekJoon11052 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] strToken = br.readLine().split(" ");
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		for(int i=1; i<=strToken.length; i++) {
			arr[i] = Integer.parseInt(strToken[i-1]);
		}
		dp[1]=arr[1];
		int max=0;
		for(int i=2;  i<=strToken.length; i++) {
			max = arr[i];
			for(int j=i-1; j>=i/2; j--) {
					max = Math.max(max, dp[j]+dp[i-j]);
			}
			dp[i]=max;
		}
		System.out.println(dp[N]);
	}	
}