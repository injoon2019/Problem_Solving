//Baekjoon - 1208 부분수열의 합 2
import java.io.*;
import java.util.*;

public class BaekJoon1208 {
	
	static ArrayList<Integer> A, B;
	static long ans ; //int :2^32 long: 2^64 >> 문제: 2^40
	static int N, S;
	static int[] arr;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken =  br.readLine().split(" ");
		
		N= Integer.parseInt(strToken[0]);
		S = Integer.parseInt(strToken[1]);
		
		arr = new int[N];
		A = new ArrayList<>();
		B = new ArrayList<>();
		ans = 0;
		
		
		strToken = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(strToken[i]);
		}
		
		//반으로 나눠서 합 구하기
		//원래 수열을 반으로 나누어 각 1~N/2, N/2~N의 
		//인덱스 안의 원소로 만들 수 있는 모든 합의 경우를 각 리스트에 오름차순으로 저장
		makeSumArray(0, 0, N/2, A);
		makeSumArray(0, N/2, N, B);
		
		//양쪽 리스트를 오름차순으로 정렬
		Collections.sort(A);
		Collections.sort(B);
		
		//처리
		int left = 0;
		int right = B.size()-1;
		
		while(left < A.size() && right >=0) {
	
			int lValue = A.get(left);
			int rValue = B.get(right);
			
			if(lValue + rValue == S) {
				//같은 합이 들어있을 수 있기 때문에 다음과 같은 체크를 해줘야한다 ?
				//left를 증가시키며 lcnt를 증가시킨다
				long lcnt = 0;
				while(left <A.size() && A.get(left)==lValue) {
					left++;
					lcnt++;
				}
				
				//right를 감소시키며 rcnt를 증가시킨다
				long rcnt = 0;
				while(right >=0 && B.get(right)== rValue) {
					right--;
					rcnt++;
				}
				ans += lcnt*rcnt;
			}
			
			if(lValue+rValue > S) {
				right--;
			}
			
			if(lValue + rValue <S) {
				left++;
			}
		}
		//S가 0일때는 아무것도 선택 안했을 경우를 빼줘야한다
		ans = S==0 ? ans-1: ans;
		System.out.println(ans);
	}	
	
	//배열안의 요소들로 만들 수 있는 모든 합의 경우
	private static void makeSumArray(int sum, int idx, int end, ArrayList<Integer> list) {
		if(idx == end) {
			list.add(sum);
			return;
		}
		//현재 idx 선택
		makeSumArray(sum+arr[idx], idx+1, end, list);
		//현재 idx 선택 안함
		makeSumArray(sum, idx+1, end, list);
	}
}