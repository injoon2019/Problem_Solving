//Baekjoon - 10971 외판원 순회 2
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
public class BaekJoon10971 {

	static int min = Integer.MAX_VALUE;
	static int[][] cost;
	public static void perm(int[] arr, int depth, int n) {
		if(depth==n) {
			sum(arr);
			return;
		}
		
		for(int i=depth; i<n; i++) {
			if(i<n-1) {
				if(cost[arr[depth]][arr[depth+1]]==0) {
					continue;
				}
			}

			swap(arr, i, depth);
			perm(arr, depth+1, n);
			swap(arr, i, depth);
		}
	}
	
	static void swap(int[] a, int depth, int n) {
		int temp = a[depth];
		a[depth] = a[n];
		a[n] = temp;
	}
	
	static void sum(int[] a) {
		int sum = 0;
		for(int i=0; i<a.length-1; i++) {
			sum += cost[a[i]][a[i+1]];
		}
		if(cost[a.length-1][a[0]]==0) {
			sum = Integer.MAX_VALUE;
		}else {
			sum += cost[a[a.length-1]][a[0]];
		}
		if(sum < min) {
			min = sum;
		}
	}
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] strToken;
		
		cost = new int[N][N];
		for(int i=0; i<N; i++) {
			strToken = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				cost[i][j] = Integer.parseInt(strToken[j]);
			}
		}
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = i;
		}
		perm(arr, 0, N);
		System.out.println(min);
	}	
}


//4
//0 0 10 10
//10 0 3 10
//10 10 0 3
//3 10 10 0