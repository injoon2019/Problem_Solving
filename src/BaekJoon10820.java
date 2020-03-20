//Baekjoon - 10820

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class BaekJoon10820 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int small ,big , num ,space;
		while((str=br.readLine())!=null) {
			small= big= num= space=0;
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)>='a' &&str.charAt(i) <='z') {
					small++;
				}else if (str.charAt(i)>='A' &&str.charAt(i) <='Z') {
					big++;
				}else if(str.charAt(i)>='0' &&str.charAt(i) <='9') {
					num++;
				}else {
					space++;
				}
			}
			
			System.out.printf("%d %d %d %d\n",small, big, num, space);
		}

	}
}