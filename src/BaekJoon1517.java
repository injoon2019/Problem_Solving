//Baekjoon - 1517 ���� ��Ʈ 
import java.io.*;
import java.util.*;

public class BaekJoon1517 {
	
	static long swapCount = 0;
	static long[] sorted;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		sorted = new long[n];
		long[] arr = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		mergeSort(arr,0,n-1);
		
		System.out.println(swapCount);
	}
	
	static void mergeSort(long[] arr, int low, int high) {
		if(low<high) {
			int mid = (low+high)/2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, high);
			merge(arr, low, mid, high);
		}
	}
	
	static void merge(long[] arr, int low, int mid, int high) {
		int i = low;
		int j = mid+1;
		int index = low;
		
		while(i<=mid && j<= high) {
			if(arr[i]<= arr[j]) {
				sorted[index++] = arr[i++];
			}
			else {
				sorted[index++] = arr[j++];
				//���� ��Ʈ�� �̿��Ͽ� ������ �ϵ�, 
				//���� ���ڰ� ���� ���ں��� ū ��쿡 ī��Ʈ�� ���ָ� �����ϰ� swap Ƚ���� ���� �� �ֽ��ϴ�.
				
				//swapCount�� (mid+1-i) �� ���ϴ� ������ ���� 
				//�迭�� �����ִ� ���ڸ�ŭ ��� swap�� �߻��ϱ� �����Դϴ�.
				swapCount += (mid+1 - i);
			}
		}
		
		while(i<=mid)
			sorted[index++] = arr[i++];
		
		while(j<= high)
			sorted[index++] = arr[j++];
		
		for(int k=low; k<=high; k++)
			arr[k]= sorted[k];
	}
}