//Baekjoon - 1517 버블 소트 
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
			if(arr[i]< arr[j]) {
				sorted[index++] = arr[i++];
			}
			else {
				sorted[index++] = arr[j++];
				//머지 소트를 이용하여 정렬을 하되, 
				//앞의 숫자가 뒤의 숫자보가 큰 경우에 카운트를 해주면 동일하게 swap 횟수를 구할 수 있습니다.
				
				//swapCount에 (mid+1-i) 를 더하는 이유는 왼쪽 
				//배열에 남아있는 숫자만큼 계속 swap이 발생하기 때문입니다.
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
