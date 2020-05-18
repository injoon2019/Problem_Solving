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
				//dp[6]�� ���� ��, dp[4]*dp[2] + dp[2]*dp[4]�� �ϸ� �ߺ��� �߻��Ѵ� 
				//dp[4]*dp[2] �� dp[2]*dp[4]�� ���� �ٸ���
				//�� ������ dp[4]�� Ư�� ���̽��� �ֱ� �����̴�
				//���� ���ڸ� ���ϰ�, ���ڿ��� Ư�����̽��� �߰��� �����ش�. 
				dp[i] += dp[i-j]*2;
			}
		}
		
		System.out.println(dp[N]);
	}	
}