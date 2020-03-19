//Baekjoon - 9012

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class BaekJoon9012 {

	public static void main(String[] args)throws Exception{

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		String str;
		for(int i=0; i<n; i++) {
			boolean fail = false;
			Stack<Character> stack = new Stack<>();
			str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j)=='(') {
					stack.push('(');
				}else {
					if(stack.empty()) {
						System.out.println("NO");
						fail=true;
						break;
					}else {
						stack.pop();
					}
				}
			}
			if(stack.empty()==  true && (!fail)) {
				System.out.println("YES");
			}else if(!fail) {
				System.out.println("NO");
			}
		}
	}	
}