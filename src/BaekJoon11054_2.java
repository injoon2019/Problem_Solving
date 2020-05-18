//Baekjoon - 11054
//https://sihyungyou.github.io/baekjoon-11054/
//https://fbtmdwhd33.tistory.com/56
import java.util.*;

public class BaekJoon11054_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		int[] incDP = new int[N];
		int[] decDP = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			incDP[i] = 1;
			decDP[i] = 1;
		}
		
		//왼쪽에서 시작하는 LIS
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i]>arr[j] && incDP[i]<=incDP[j]) {
					incDP[i]= incDP[j]+1;
				}
			}
		}
		
		for(int i=N-1; i>=0; i--) {
			for(int j=N-1; j>i; j--) {
				if(arr[i]>arr[j] && decDP[i]<=decDP[j]) {
					decDP[i]= decDP[j]+1;
				}
			}
		}
		
		int max = incDP[0]+decDP[0];
		
		for(int i=0; i<N; i++) {
			max = Math.max(max, incDP[i]+decDP[i]);
		}
		
		System.out.println(max-1);
	}

}