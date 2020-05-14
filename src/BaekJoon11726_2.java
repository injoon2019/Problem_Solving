//Baekjoon - 11726_2
import java.io.*;
import java.util.*;
public class BaekJoon11726_2 {
	static int[] dp = new int[1001];
	static int mod = 10007;
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<=1000; i++) {
			dp[i] = dp[i-1]%mod+ dp[i-2]%mod;
		}
		
		System.out.println(dp[n]%mod);
	}	
}