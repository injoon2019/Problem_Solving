//Baekjoon - 2089

import java.io.*;
import java.util.Arrays;
public class BaekJoon2089 {

	
	public static void main(String[] args)throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		if(input==0) {
			System.out.println(0);
		}else {
			while(input !=0) {
				if(input%-2 == -1) {
					sb.append(1);
					input = (input-1)/-2;
				}else {
					sb.append(input%-2);
					input = input/-2;
				}
			}
			System.out.println(sb.reverse());
		}
		
	}	
	
}