//Baekjoon - 10819

import java.io.*;
public class BaekJoon10819 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] strToken = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(strToken[i]);
		}
		
		int max = Integer.MIN_VALUE;
		int tmp = 0;
		
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				tmp= arr[j];
				arr[j] = arr[i];
				arr[i]=tmp;
				int cur = arrSum(arr);
				if(cur>max)
					max=cur;
			}
		}
		System.out.println(max);
		
	}	
	
	public static int arrSum(int[] arr) {
		int sum=0;
		for(int i=0; i<arr.length-1; i++) {
			sum += Math.abs(arr[i]-arr[i+1]);
		}
		return sum;
	}
}