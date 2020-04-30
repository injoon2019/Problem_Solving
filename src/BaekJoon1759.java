
//Baekjoon - 1759 암호 만들기 
import java.io.*;
import java.util.*;

public class BaekJoon1759 {

	static int L, C;
	static char[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken = br.readLine().split(" ");

		L = Integer.parseInt(strToken[0]);
		C = Integer.parseInt(strToken[1]);
		arr = new char[C];
		strToken = br.readLine().split(" ");
		for(int i=0; i<C; i++) {
			arr[i] = strToken[i].charAt(0);
		}
		Arrays.parallelSort(arr);
		combination(arr, 0, L, C, 0);

	}
}
