//Baekjoon - 10819 ���̸� �ִ�� (����!)
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
		//depth�� 0�̶�� 1xxx, 2xxx, 3xxx, 4xxx �׹� ����
		for(int i=depth; i<n; i++) {
			swap(a, i, depth);
			perm(a, depth+1, n);
			//�ι�° swap()�� ���ܰ��� �б��������� �迭�� ������ ����ϰ� �̸� �ʱ�ȭ�ϴ� �۾�
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