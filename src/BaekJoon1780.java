//Baekjoon - 1780 ������ ���� 
import java.io.*;
import java.util.*;

public class BaekJoon1780 {
	
	public static int size;
	public static int[] cnt;
	public static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] strToken = br.readLine().split(" ");
		size = Integer.parseInt(strToken[0]);
		arr = new int[size][size];
		cnt = new int[3];
		
		for(int i=0; i<size; i++) {
			strToken = br.readLine().split(" ");
			for(int j=0; j<size; j++) {
				arr[i][j] = Integer.parseInt(strToken[j])+1;
			}
		}
		divideAndConquer(0,0,size);		
		
		System.out.println(cnt[0] + "\n" + cnt[1] + "\n" + cnt[2]);
	}
	
	public static boolean isAble(int r, int c, int len ) {
		int t = arr[r][c];
		
		for(int i=r; i<r+len; i++) {
			for(int j=c; j<c+len; j++) {
				if(t!= arr[i][j])
					return false;
			}
		}
		return true;
	}
	
	public static void divideAndConquer(int r, int c, int len) {
		//������ �ش� ���� ī��Ʈ�� 1 ���� �����ش�
		if(isAble(r,c,len)) {
			cnt[arr[r][c]]++;
		}else {
			//�ٸ��� len�� 3���� ������, 3���� �����ſ� ���� ù �ε����� �ش��ϴ� ��ǥ�� ��ȣ��
			// 0~8�� len�� 9���µ� ������ �ȵƴٸ� len�� 3�� �ǰ�, 
			//  {0, 0}, {0, 3}, {0, 6}
			//	{3, 0}, {3, 3}, {3, 6}
			//	{6, 0}, {6, 3}, {6, 6}
			//���� ��ǥ + ���ο� ���� *0 or 1or 2 -> 9�� ���� ���ο� ��ǥ�� ���´�
			
			int newlen = len/3;
			
			for(int i=0;  i<3; i++) {
				for(int j=0; j<3; j++) {
					divideAndConquer(r+newlen*i, c+newlen*j, newlen);
				}
			}
		}
	}
}
