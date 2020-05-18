//Baekjoon - 11055_2

import java.io.*;
public class BaekJoon11055_2 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		String[] strToken = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(strToken[i]);
			dp[i] = arr[i];
		}
		
		//dp[i] = i까지 증가하는 수열의 가장 큰 합 
		
		// 1 5 3 3 3 10
		for(int i=1; i<N; i++) {
			int max = 0;
			for(int j=0; j<i; j++) {
				if(arr[i]>arr[j]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] +=max;
		}
		
		int max = dp[0];
		for(int i=0; i<N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}	
}