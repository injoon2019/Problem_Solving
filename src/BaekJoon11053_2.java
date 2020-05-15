//Baekjoon - 11053

import java.io.*;
public class BaekJoon11053_2 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] strToken = br.readLine().split(" ");
		int[] arr = new int[N];
		int[] dp = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(strToken[i]);
			//8 9 10 1 2 3 4 같은 경우 1에서 시작할 수 있다.
			//즉 어떤 곳에서든 시작할 수 있으므로 모두 1로 초기화를 한다
			dp[i]=1;
		}
		int max = dp[0];
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i]> arr[j] && dp[i]<dp[j]+1) {
					dp[i] = dp[j]+1;
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}	
}