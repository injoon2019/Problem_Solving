//Baekjoon - 10872

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class BaekJoon10872 {
	public static long Factorial(long n) {
		if(n==1 || n==0)
			return 1;
		else{
			return n*Factorial(n-1);
		}
	}

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.parseInt(br.readLine());
		
		System.out.println(Factorial(n));

	}	
}