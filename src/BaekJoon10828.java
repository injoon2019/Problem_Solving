//Baekjoon - 10828

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class BaekJoon10828 {

	public static void main(String[] args)throws Exception{

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		String[] strToken;
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<n; i++) {
			strToken = br.readLine().split(" ");
			if(strToken[0].equals("push")) {
				stack.push(Integer.parseInt(strToken[1]));
				
			}else if(strToken[0].equals("top")) {
				if(!stack.empty()) {
					System.out.println(stack.peek());
				}else {
					System.out.println(-1);
				}
			}else if(strToken[0].equals("size")) {
				System.out.println(stack.size());
				
			}else if(strToken[0].equals("empty")) {
				if(stack.empty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				
			}else if(strToken[0].equals("pop")) {
				if(!stack.empty()) {
					System.out.println(stack.pop());
				}else {
					System.out.println(-1);
				}
			}
		}
	}	
}