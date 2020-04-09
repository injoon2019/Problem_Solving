//Baekjoon - 2805 나무 자르기 
import java.io.*;
import java.util.*;

public class BaekJoon2805 {
	
	public static void main(String[] args) throws Exception {		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]= scan.nextInt();
		}
		Arrays.parallelSort(arr);
		long max = arr[N-1];
		long min=1;
		long mid=0;
		long meter=0;
		
		while(min<=max) {
			mid = (min+max)/2;
			meter = calc(arr, mid);
			if(meter<M) {
				max = mid-1;
			}
			else if(meter >=M) {
				min = mid+1;
			}
		}
		System.out.println(max);
	}
	
	private static long calc(int[] arr, long mid) {
		long sum = 0;
		for(int i=0; i<arr.length;i++) {
			
			if(arr[i]-mid<0) {	//이게 중요하다! 이걸 까먹기 쉬운데 이렇지 않으면 답이 달라진다. 
				continue;
			}
			sum += (arr[i]-mid);
		}
		return sum;
	}
}



