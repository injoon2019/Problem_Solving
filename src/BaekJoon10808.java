//Baekjoon - 10808

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class BaekJoon10808 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;
		str = br.readLine();
		int[] arr = new int[26];
		for(int i=0; i<str.length(); i++) {
			arr[str.charAt(i)-'a']++;
		}
		
		for(int i=0; i<arr.length-1; i++) {
			System.out.printf("%d ", arr[i]);
		}
		System.out.printf("%d", arr[arr.length-1]);
	}
}