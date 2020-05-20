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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken())-1;
		
		array = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.parallelSort(array);
		bw.write(array[k]+"");
		bw.close();
	}


}