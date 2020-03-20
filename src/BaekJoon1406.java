//Baekjoon - 1406

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class BaekJoon1406 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
		String[] strToken;
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		for(int i=0; i<str.length(); i++) {
			left.push(str.charAt(i));
		}
		String cmd;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			strToken = br.readLine().split(" ");
			cmd = strToken[0];
			switch(cmd) {
				case "L":{
					if(!left.empty()) {
						right.push(left.pop());
					}
						break;
				}
				case "D":{
					if(!right.empty()) {
						left.push(right.pop());
					}
					break;
				}
				case "B":{
					if(!left.empty()) {
						left.pop();
					}
					break;
				}
				case "P":{
					left.push(strToken[1].charAt(0));
					break;
				}		
			}
		}
		int size = left.size();
		for(int i=0; i<size;  i++) {
			right.push(left.pop());
		}
		size = right.size();
		for(int i=0; i<size; i++) {
			sb.append(right.pop());
		}
		bw.append(sb);
		bw.flush();
	}
}