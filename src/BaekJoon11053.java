//Baekjoon - 11053

import java.io.*;
public class BaekJoon11053 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] strToken = br.readLine().split(" ");
		int[] arr = new int[N];
		int[] dp = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(strToken[i]);
			//8 9 10 1 2 3 4 ���� ��� 1���� ������ �� �ִ�.
			//�� � �������� ������ �� �����Ƿ� ��� 1�� �ʱ�ȭ�� �Ѵ�
			dp[i]=1;
		}
		
		//������ �ڽ� ���� ������ ����� ���ؼ� ������ arr ���� �۴ٸ�
		//�ش� dp�� ����� ���� 1�� ���ؼ� ���� �����ϴ� ����̴�. �ٸ�
		//������ �ڽ��� ������ ���� ��� ������ ����� �񱳸� �ؾ��Ѵ�. 
		for(int i=1; i<N; i++) {
			boolean check =false;
			int max=0;
			for(int j=0; j<=i; j++) {
				if(arr[i]> arr[j]) {
					max = Math.max(max, dp[j]);
					check=true;
				}
			}
			if(check) {
				dp[i] = max+1;
			}
		}
		
		int max =dp[0];
		for(int i=0; i<N; i++) {
			max= Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}	
}