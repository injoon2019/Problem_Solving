//Baekjoon - 1373

import java.io.*;
import java.util.Arrays;
public class BaekJoon1373 {
	
	public static void main(String[] args)throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int length = str.length();
		int start=0;
		
		if(length%3==1) {
			System.out.printf("%d", str.charAt(0)-48);
			start=1;
		}
		if(length%3==2) {
			System.out.printf("%d",(str.charAt(0)-48)*2+str.charAt(1)-48);
			start=2;
		}
		length%=3;
		int check=0;
		check +=length;
		while(check<=str.length()) {
			System.out.printf("%d", (str.charAt(start)-48)*4 + (str.charAt(start+1)-48)*2+ (str.charAt(start+2)-48));
			start+=3;
			check+=start;
		}
		
	}	
}