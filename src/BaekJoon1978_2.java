//Baekjoon - 1978

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
public class BaekJoon1978_2 {
	static int[] arr;
	static boolean[] erathos = new boolean[1001];
	
	public static void Erathos() {
		erathos[1]=true;
		for(int i=2; i*i<=1000; i++) {
			for(int j=i*2; j<=1000; j+=i) {
				erathos[j] = true;
			}
		}
	}
	public static void main(String[] args)throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] strToken = br.readLine().split(" ");
		arr = new int[strToken.length];
		Erathos();
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			arr[i]= Integer.parseInt(strToken[i]);
			if (erathos[arr[i]]== false) {
				count++;
			}
		}
		System.out.println(count);
		
		
		
	}	
}