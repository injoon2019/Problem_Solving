//Baekjoon - 1699

import java.io.*;
public class BaekJoon1699 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//�����ؾ� �� ���� n�� 12�� ����, 2�� ���� 3���� ǥ���� �����ϹǷ� 3�� ���� + 1�� ���� 3������ ���� ���� ������ ǥ���� �����ϴ�
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[100001];
		// dp[n] = n�� ���������� ������ ǥ���� �� �� ���� �ּ� ����
        // dp[n] = d[n-i^2] + 1 (�������� ����� ������ �� �� = (i^2)���� �ϳ��ϱ� 1)
		
        for (int i = 1; i <= N; i++){
        	// i���� �ִٰ� �ʱ�ȭ �ϰ� ���� ( ��� ���� 1^2�� �ո����� ��Ÿ�� �� ������!  )
            dp[i] = i;
            // ������ ���� N���� Ŭ���� ������ i (N) ���� �ݺ��ϸ�
            for (int j = 1; j*j <= i; j++){
                if (dp[i] > dp[i-j*j]+1){
                	// d[i]�� d[i - j * j] + 1 ���ؼ� ������ �ּ� ���� ���� 
                    dp[i] = dp[i-j*j]+1;
                }
            }
        }

		System.out.println(dp[N]);
	}
	
}