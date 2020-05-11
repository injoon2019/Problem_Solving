//Baekjoon - 2632 �����Ǹ�
import java.io.*;
import java.util.*;

public class BaekJoon2632 {	
	static int target;
	static int m,n;
	static int[] A,B;
	static boolean[] check;
	static ArrayList<Integer> AList = new ArrayList<>();
	static ArrayList<Integer> BList = new ArrayList<>();
	static int ans = 0;
	
	public static void main(String[] args) throws Exception {		
		Scanner sc = new Scanner(System.in);
		target = sc.nextInt();
		m = sc.nextInt();
		n = sc.nextInt();
		
		A = new int[m];
		B = new int[n];
		
		for(int i=0; i<m; i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			B[i] = sc.nextInt();
		}
		
		for(int i=0; i<m; i++) {
			//üũ �迭 �ʱ�ȭ
			check = new boolean[m];
			//ù��° ���� ���
			check[i]=true;
			getSum(A[i], i, i+1, check, A, AList);
		}
		
		for(int i=0; i<n; i++) {
			//üũ �迭 �ʱ�ȭ
			check = new boolean[n];
			//ù ��° ���� ���
			check[i] = true;
			getSum(B[i], i, i+1, check, B, BList);
		}
		
		//���� ���� ������ ���� ��쵵 �����Ƿ�
		AList.add(0);
		BList.add(0);
		
		Collections.sort(AList);
		Collections.sort(BList);
		
		int leftIdx = 0;
		int rightIdx = BList.size()-1;
		
		while(leftIdx < AList.size() && rightIdx >=0) {
			int lv = AList.get(leftIdx);
			int rv = BList.get(rightIdx);
			
			if(lv+rv == target) {
				int lc = 0;
				int rc = 0;
				
				while(leftIdx < AList.size() && AList.get(leftIdx)==lv) {
					lc++;
					leftIdx++;
				}
				
				while(rightIdx >= 0 && BList.get(rightIdx)==rv) {
					rc++;
					rightIdx--;
				}
				
				ans += lc*rc;
			}
			
			if(lv+rv > target)
				rightIdx--;
			if(lv+rv < target)
				leftIdx++;
		}
		System.out.println(ans);
	}
	
	
	//��ȯ ť �����ϵ���
	public static void getSum(int sum, int startIdx, int idx, boolean[] check, int[] arr, List list) {
		if(idx == arr.length)
			idx = 0;
		
		list.add(sum);
		
		//���� �ȴ��� ���������� ���ؼ��� && ��ȯ����
		if(check[idx]==false && sum <= target && idx != startIdx-1) {
			check[idx] = true;
			getSum(sum+ arr[idx], startIdx, idx+1, check, arr, list);
		}else {
			return;
		}
	}

}



