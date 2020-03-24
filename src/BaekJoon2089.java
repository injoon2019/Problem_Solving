//Baekjoon - 2089

import java.io.*;
import java.util.Arrays;
public class BaekJoon2089 {

	
	public static void main(String[] args)throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(input !=0) {
			System.out.println(input%-2);
			sb.append(input%-2);
			input /= -2;
		}
		for(int i=sb.length()-1; i>=0; i--) {
			System.out.printf("%c", sb.charAt(i));
		}
		
	}	
	
}