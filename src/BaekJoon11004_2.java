//Baekjoon - 11004
//Quick Sort - https://mygumi.tistory.com/308
//Quick Sort - https://fbtmdwhd33.tistory.com/85
//https://fbtmdwhd33.tistory.com/86
//https://www.acmicpc.net/source/18510644
import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class BaekJoon11004_2 {
	static int[] array;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken())-1;
		
		array = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf((select(k))));
		bw.close();
	}
	
	public static int select(int k) {
		int low = 0;
		int high = n-1;
		while(low< high) {
			int m = (high+ low)/2;
			swap(low, m);
			int j = partition(low, high);
			if(j < k) low = j+1;
			else if(j>k) high = j-1;
			else return array[k];
		}
		return array[k];
	}
	
	public static int partition(int low, int high) {
		int i= low;
		int j = high+1;
		while(true) {
			while(array[++i] < array[low]) {
				if(i==high) break;
			}
			while( array[--j]> array[low]) {
				if(j==low) break;
			}
			if(i>=j)break;
			swap(i,j);
		}
		swap(low, j);
		return j;
	}
	
	public static void swap(int i, int j) {
		int tmp = array[i];
		array[i]= array[j];
		array[j]= tmp;
	}

}