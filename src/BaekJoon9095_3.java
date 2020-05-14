//Baekjoon - 9095_3

import java.io.*;
import java.util.*;
public class BaekJoon9095_3 {
	static int[] dp = new int[11];
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		for(int i=4;i<=10; i++) {
			dp[i]= dp[i-1]+ dp[i-2]+dp[i-3];
		}
		
		for(int n=0; n<N; n++) {
			int t = sc.nextInt();
			System.out.println(dp[t]);
		}
		
	}	
}