//Baekjoon - 1212

import java.io.*;
import java.util.Arrays;
public class BaekJoon1212 {
	static StringBuilder answer = new StringBuilder();
	static String inputs;
	
	public static void main(String[] args)throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] first = {"0", "1", "10", "11", "100", "101", "110", "111"};
		String[] str = {"000", "001", "010", "011", "100", "101", "110", "111"};
		inputs = br.readLine();
		int len = inputs.length();
		for(int i=0; i<len; i++) {
			if(i==0) {
				answer.append(first[inputs.charAt(i)-'0']);
			}else {
				answer.append(str[inputs.charAt(i)-'0']);
			}
			
		}
		System.out.println(answer);
	}	
}