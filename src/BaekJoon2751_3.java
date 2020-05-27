//Baekjoon - 2751

import java.io.*;
public class BaekJoon2751_3 {
	private static void mergeSort(int[] arr) {
		int[] tmp = new int[arr.length];
		mergeSort(arr, tmp, 0, arr.length-1);
	}
	
	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		if(start<end) {
			int mid = (start+end)/2;
			mergeSort(arr, tmp, start, mid);
			mergeSort(arr, tmp, mid+1, end);
			merge(arr, tmp, start, mid, end);
		}
	}
	
	private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		for(int i=start; i<=end; i++) {
			tmp[i] = arr[i];
		}
		
		int part1 = start;
		int part2 = mid+1;
		int index = start;
		while(part1 <=mid && part2 <=end) {
			if(tmp[part1] < tmp[part2]) {
				arr[index] = tmp[part1];
				part1++;
			}else {
				arr[index] = tmp[part2];
				part2++;
			}
			index++;
		}
		//�� part2�� ������ ���� ó�� �����ֳ�?
		//�ֳĸ� ��¥�� arr �޺κп��� part2�� �����ϱ�
		for(int i=0; i<=mid-part1; i++) {
			arr[index+i] = tmp[part1+i];
		}
		
	}
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr= new int[N];
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		mergeSort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}

	}
	

}