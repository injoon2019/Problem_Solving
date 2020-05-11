//Baekjoon - 2632 피자판매
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
			//체크 배열 초기화
			check = new boolean[m];
			//첫번째 조각 담기
			check[i]=true;
			getSum(A[i], i, i+1, check, A, AList);
		}
		
		for(int i=0; i<n; i++) {
			//체크 배열 초기화
			check = new boolean[n];
			//첫 번째 조각 담기
			check[i] = true;
			getSum(B[i], i, i+1, check, B, BList);
		}
		
		//각각 전혀 사용되지 않을 경우도 있으므로
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
	
	
	//순환 큐 구현하듯이
	public static void getSum(int sum, int startIdx, int idx, boolean[] check, int[] arr, List list) {
		if(idx == arr.length)
			idx = 0;
		
		list.add(sum);
		
		//아직 안담은 피자조각에 대해서만 && 순환방지
		if(check[idx]==false && sum <= target && idx != startIdx-1) {
			check[idx] = true;
			getSum(sum+ arr[idx], startIdx, idx+1, check, arr, list);
		}else {
			return;
		}
	}

}



