//Baekjoon - 1978

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
public class BaekJoon1978 {
	static int[] arr;
	public static int Erathos(int max) {
		
		int count=0;
		boolean[] eraArr =  new boolean[max+1];
		
		for(int i=2; i<=Math.sqrt(max); i++) {
			if(eraArr[i]) {
				//이미 걸러진 수의 배수는 skip
				continue;
			}
			for(int j=i+i; j<=max; j+=i) {
				eraArr[j]=true;
			}
		}
		
		for(int i=0; i<arr.length;i++) {
			if(eraArr[arr[i]] == false) {
				if(arr[i]!=0 && arr[i]!=1)
					count++;
			}
		}
		return count;
		
	}
	
	public static void main(String[] args)throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] strToken = br.readLine().split(" ");
		arr = new int[strToken.length];
		for(int i=0; i<arr.length; i++) {
			arr[i]= Integer.parseInt(strToken[i]);
		}
		Arrays.sort(arr);

		int max = arr[arr.length-1];
		System.out.println(Erathos(max));
		
	}	
}