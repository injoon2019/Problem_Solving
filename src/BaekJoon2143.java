//Baekjoon - 2143 �� �迭�� �� 
import java.io.*;
import java.util.*;

public class BaekJoon2143 {	
	
	static int[] A, B;
	static ArrayList<Long> sumA, sumB;
	static int N, M;
	static long T, cnt;
	
	public static void main(String[] args) throws Exception {		
		// ������ �Է� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Long.parseLong(br.readLine());
		N = stoi(br.readLine());
		
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; ++i) {
			A[i] = stoi(st.nextToken());
		}
		
		M = stoi(br.readLine());
		B = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; ++i) {
			B[i] = stoi(st.nextToken());
		}
		
		cnt = 0;
		sumA = new ArrayList<>();
		sumB = new ArrayList<>();
		
		// �� ����Ʈ ����� 
		for(int i = 0 ; i < N ; ++i) {
			long sum = 0;
			for(int j = i ; j < N ; ++j) {
				sum += A[j];
				sumA.add(sum);
			}
		}
		
		for(int i = 0 ; i < M ; ++i) {
			long sum = 0;
			for(int j = i ; j < M ; ++j) {
				sum += B[j];
				sumB.add(sum);
			}
		}
		
		// ����Ž��(lower, upper bound)�� ����ϱ� ���ؼ��� ������������ ���ĵǾ� �־���Ѵ�
		Collections.sort(sumA);
		Collections.sort(sumB);
		
		for(int i = 0 ; i < sumA.size() ; ++i) {
			long target = T - sumA.get(i);
			cnt += upper_bound(0, sumB.size(), target) - lower_bound(0, sumB.size(), target);
		}
		
		System.out.println(cnt);
	}
	
	// lower_bound�� list���� target�� �����ϴ� ù ��° index�� ��ȯ�Ѵ�.
	private static int lower_bound(int left, int right, long target) {
		while(left < right) {
			int mid = (left + right) / 2;
			if(sumB.get(mid) < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}
	
	// upper_bound�� list���� ������ target�� ���� index�� ��ȯ�Ѵ�.
	private static int upper_bound(int left, int right, long target) {
		while(left < right) {
			int mid = (left + right) / 2;
			if(sumB.get(mid) <= target) { // target�� ���� ���� left�� �����Ѵ�.
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}
	
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}



