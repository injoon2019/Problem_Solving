//Baekjoon - 10820

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class BaekJoon10820_2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while((str=br.readLine()) !=null) {
			int low=0;
			int up = 0;
			int num = 0;
			int space = 0;
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)>='a' && str.charAt(i)<='z')
					low++;
				if(str.charAt(i)>='A' && str.charAt(i)<='Z')
					up++;
				if(str.charAt(i)>='0' && str.charAt(i)<='9')
					num++;
				if(str.charAt(i)==' ')
					space++;
				
			}
			System.out.println(low+" "+up+" "+num+" "+space);
		}

	}
}