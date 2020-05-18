//Baekjoon - 2133_2
import java.io.*;
public class BaekJoon2133_2 {
	///https://jaimemin.tistory.com/330
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[31];
		dp[0]=1;
		dp[2] = 3;
		for(int i=4; i<=N; i+=2) {
			dp[i] = dp[i-2]*dp[2];
			for(int j=4; j<=i; j+=2) {
				//dp[6]을 구할 때, dp[4]*dp[2] + dp[2]*dp[4]를 하면 중복이 발생한다 
				//dp[4]*dp[2] 와 dp[2]*dp[4]는 조금 다르다
				//그 이유는 dp[4]에 특수 케이스가 있기 때문이다
				//따라서 전자를 구하고, 후자에서 특별케이스만 추가로 더해준다. 
				dp[i] += dp[i-j]*2;
			}
		}
		
		System.out.println(dp[N]);
	}	
}