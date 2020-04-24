//Baekjoon - 10819 차이를 최대로 (순열!)
//https://gorakgarak.tistory.com/522
import java.io.*;
import java.util.StringTokenizer;
public class BaekJoon10819 {
	static int max=0;
	public static void perm(int[] a, int depth, int n) {
		if(depth==n) {
			sum(a,n);
			return;
		}
		//depth가 0이라면 1xxx, 2xxx, 3xxx, 4xxx 네번 돈다
		for(int i=depth; i<n; i++) {
			swap(a, i, depth);
			perm(a, depth+1, n);
			//두번째 swap()은 전단계의 분기점에서의 배열의 순서를 기억하고 이를 초기화하는 작업
			swap(a, i, depth);
		}
	}
	
	static void swap(int[] a, int depth, int n) {
		int temp = a[depth];
		a[depth] = a[n];
		a[n] = temp;
	}
	
	static void sum(int[] a, int k) {
		int sum = 0;
		for(int i=2; i<=k; i++) {
			sum += Math.abs(a[i-2]-a[i-1]);
		}
		if(max<sum) {
			max = sum;
		}
	}
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		String number = br.readLine();
		StringTokenizer st = new StringTokenizer(number, " ");
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		perm(num, 0, N);
		System.out.println(max);
	}	
}