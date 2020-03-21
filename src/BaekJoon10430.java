//Baekjoon - 10430

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.*;
public class BaekJoon10430 {
	
	private static final String PRE = "<";
	private static final String SPACE = ", ";
	private static final String POST = ">";

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken= br.readLine().split(" ");
		int A = Integer.parseInt(strToken[0]);
		int B = Integer.parseInt(strToken[1]);
		int C = Integer.parseInt(strToken[2]);
		
		System.out.println((A+B)%C);
		System.out.println(((A%C) + (B%C))%C);
		System.out.println((A*B)%C);
		System.out.println(((A%C) * (B%C))%C);
		
	}
}