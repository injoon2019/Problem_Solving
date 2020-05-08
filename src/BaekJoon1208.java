//Baekjoon - 1208 �κм����� �� 2
import java.io.*;
import java.util.*;

public class BaekJoon1208 {
	
	static ArrayList<Integer> A, B;
	static long ans ; //int :2^32 long: 2^64 >> ����: 2^40
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
		
		//������ ������ �� ���ϱ�
		//���� ������ ������ ������ �� 1~N/2, N/2~N�� 
		//�ε��� ���� ���ҷ� ���� �� �ִ� ��� ���� ��츦 �� ����Ʈ�� ������������ ����
		makeSumArray(0, 0, N/2, A);
		makeSumArray(0, N/2, N, B);
		
		//���� ����Ʈ�� ������������ ����
		Collections.sort(A);
		Collections.sort(B);
		
		//ó��
		int left = 0;
		int right = B.size()-1;
		
		while(left < A.size() && right >=0) {
	
			int lValue = A.get(left);
			int rValue = B.get(right);
			
			if(lValue + rValue == S) {
				//���� ���� ������� �� �ֱ� ������ ������ ���� üũ�� ������Ѵ� ?
				//left�� ������Ű�� lcnt�� ������Ų��
				long lcnt = 0;
				while(left <A.size() && A.get(left)==lValue) {
					left++;
					lcnt++;
				}
				
				//right�� ���ҽ�Ű�� rcnt�� ������Ų��
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
		//S�� 0�϶��� �ƹ��͵� ���� ������ ��츦 ������Ѵ�
		ans = S==0 ? ans-1: ans;
		System.out.println(ans);
	}	
	
	//�迭���� ��ҵ�� ���� �� �ִ� ��� ���� ���
	private static void makeSumArray(int sum, int idx, int end, ArrayList<Integer> list) {
		if(idx == end) {
			list.add(sum);
			return;
		}
		//���� idx ����
		makeSumArray(sum+arr[idx], idx+1, end, list);
		//���� idx ���� ����
		makeSumArray(sum, idx+1, end, list);
	}
}