//Baekjoon - 10866

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.*;
public class BaekJoon10866 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<>();
		String[] strToken;
		for(int i=0; i<n; i++) {
			strToken = br.readLine().split(" ");
			if(strToken[0].equals("push_front")) {
				deque.addFirst(Integer.parseInt(strToken[1]));
			}else if(strToken[0].equals("push_back")) {
				deque.addLast(Integer.parseInt(strToken[1]));
				
			}else if(strToken[0].equals("pop_front")) {
				if(deque.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(deque.pollFirst());
				}
				
			}else if(strToken[0].equals("pop_back")) {
				if(deque.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(deque.pollLast());
				}
				
			}else if(strToken[0].equals("size")) {
				System.out.println(deque.size());
				
			}else if(strToken[0].equals("empty")) {
				if(deque.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}else if(strToken[0].equals("front")) {
				if(deque.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(deque.peekFirst());
				}
				
			}else if(strToken[0].equals("back")) {
				if(deque.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(deque.peekLast());
				}
			}
		}
	}
}