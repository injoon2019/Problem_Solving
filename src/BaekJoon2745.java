//Baekjoon - 2745

import java.io.*;
import java.util.Arrays;
public class BaekJoon2745 {
	
	public static void main(String[] args)throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken = br.readLine().split(" ");
		int sum=0;
		int num = Integer.parseInt(strToken[1]);
		for(int i=0; i<strToken[0].length(); i++) {
			if(strToken[0].charAt(i)>='A') {
				sum += (strToken[0].charAt(i)-55)*(int)Math.pow(num, strToken[0].length()-1-i);
			}else {
				sum += (strToken[0].charAt(i)-'0')*(int)Math.pow(num, strToken[0].length()-1-i);
			}
			
		}
		System.out.println(sum);
	}	
}