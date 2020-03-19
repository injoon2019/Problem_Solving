//Baekjoon - 10799

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class BaekJoon10799 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;
		boolean fail = false;
		Stack<Character> stack = new Stack<>();
		int count = 0;
		str = br.readLine();
		for (int j = 0; j < str.length(); j++) {
			if (str.charAt(j) == '(') {
				stack.push('(');
			} else {
				if (str.charAt(j-1)=='(') {
					stack.pop();
					//System.out.println(stack.size());
					count += stack.size();
				}else {
					if(stack.size()!=0) {
						count++;
					}
					stack.pop();
				}
			}
		}
		System.out.println(count);
	}
}