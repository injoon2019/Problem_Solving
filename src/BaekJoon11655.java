//Baekjoon - 11655

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class BaekJoon11655 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		str = br.readLine();
		int temp;
		char charTemp;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)>='a' && str.charAt(i)<='z') {
				temp = str.charAt(i)- 'a';
				temp +=13;
				temp %= 26;
				temp +='a';
				charTemp = (char)temp;
				sb.append(charTemp);
				
			}else if(str.charAt(i)>='A' && str.charAt(i)<='Z') {
				temp = str.charAt(i)- 'A';
				temp +=13;
				temp %= 26;
				temp +='A';
				charTemp = (char)temp;
				sb.append(charTemp);
			}else {
				sb.append(str.charAt(i));
			}
		}
		System.out.println(sb);
	}
}