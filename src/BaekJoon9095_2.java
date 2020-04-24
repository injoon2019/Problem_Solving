//Baekjoon - 9095_2 완전탐색으로 풀기

import java.io.*;
import java.util.Scanner;
public class BaekJoon9095_2 {
	
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int tests = sc.nextInt();
		for(int i=0; i<tests; i++) {
			int n = sc.nextInt();
			System.out.println(partition(n));
		}
		sc.close();		
	}	
	
	private static int partition(int n) {
		if(n==0) {
			return 1;
		}else if(n<0) {
			return 0;
		}else {
			int sum = 0;
			for(int i=3; i>0; i--) {
				sum += partition(n-i);
			}
			return sum;
		}
	}
}