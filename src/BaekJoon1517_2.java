//Baekjoon - 1517 버블 소트 
import java.io.*;
import java.util.*;

public class BaekJoon1517_2 {
	
	public static long[] arr;
	public static long[] sorted;
	public static long swapCount=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new long[N];
		sorted = new long[N];
		
		st  = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		mergeSort(arr, 0, N-1);
		System.out.println(swapCount);		
	}
	
	static void mergeSort(long[] arr, int low, int high) {
		if(low<high) {
			int mid = (low+high)/2;
			mergeSort(arr, low,mid);
			mergeSort(arr, mid+1, high);
			merge(arr, low, mid, high);
		}
	}
	
	static void merge(long[] arr, int low, int mid, int high) {
		int i = low;
		int j = mid+1;
		int index = low;
		
		while(i<=mid && j<=high) {
			if(arr[i]<= arr[j]) {
				sorted[index++] = arr[i++];
			}else {
				sorted[index++] = arr[j++];
				swapCount += (mid-i+1);
			}
		}
		
		while(i<=mid) {
			sorted[index++] = arr[i++];
		}
		
		while(j<=high) {
			sorted[index++] = arr[j++];
		}
		
		for(int k= low;  k<=high; k++) {
			arr[k]= (int) sorted[k];
		}
	}
}
