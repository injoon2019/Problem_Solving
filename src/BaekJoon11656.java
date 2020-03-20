//Baekjoon - 10824

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class BaekJoon11656 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String[] sArr =new String[str.length()];
		for(int i=0; i<str.length(); i++) {
			sArr[i]= str.substring(i);
		}
		Arrays.parallelSort(sArr);
		for(int i=0; i<str.length(); i++) {
			System.out.println(sArr[i]);
		}
		
	}
}