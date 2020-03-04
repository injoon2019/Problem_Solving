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
			//8 9 10 1 2 3 4 같은 경우 1에서 시작할 수 있다.
			//즉 어떤 곳에서든 시작할 수 있으므로 모두 1로 초기화를 한다
			dp[i]=1;
		}
		
		//현재의 자신 값을 과거의 값들과 비교해서 과거의 arr 값이 작다면
		//해당 dp에 저장된 값에 1을 더해서 새로 저장하는 방식이다. 다만
		//현재의 자신의 값보다 작은 모든 과거의 값들과 비교를 해야한다. 
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