//Baekjoon - 10824

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class BaekJoon10824 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String front, back;
		String[] strToken = br.readLine().split(" ");
		front = strToken[0]+strToken[1];
		back = strToken[2]+strToken[3];
		long sum =  Long.parseLong(front)+Long.parseLong(back);
		System.out.println(sum);
	}
}