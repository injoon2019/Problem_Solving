//Baekjoon - 1406_2

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class BaekJoon1406_2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<str.length(); i++) {
			stack1.push(str.charAt(i));
		}
		
		for(int i=0; i<N; i++) {
			String[] strToken = br.readLine().split(" ");
			char first = strToken[0].charAt(0);
			
			switch(first) {
			case 'L':
				if(!stack1.isEmpty())
					stack2.push(stack1.pop());
				break;
				
			case 'D':
				if(!stack2.isEmpty())
					stack1.push(stack2.pop());
				break;
			
			case 'B':
				if(!stack1.isEmpty())
					stack1.pop();
				break;
			
			case 'P':
				char last = strToken[1].charAt(0);
				stack1.push(last);
				break;
			}
		}
		
		while(!stack1.isEmpty()) {
			sb1.append(stack1.pop());
		}
		sb1.reverse();
		while(!stack2.isEmpty()) {
			sb2.append(stack2.pop());
		}
		sb3.append(sb1).append(sb2);
		bw.append(sb3);
		bw.flush();
	}
}