//Baekjoon - 10845

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.*;
public class BaekJoon10845 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;
		boolean fail = false;
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		String[] strToken;
		int latest=0;
		for(int i=0; i<n; i++) {
			strToken = br.readLine().split(" ");
			if(strToken[0].equals("push")) {
				queue.add(Integer.parseInt(strToken[1]));
				latest = Integer.parseInt(strToken[1]);
			}else if(strToken[0].equals("front")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(queue.peek());
				}
				
			}else if(strToken[0].equals("back")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(latest);
				}
				
			}else if(strToken[0].equals("size")) {
				System.out.println(queue.size());
				
			}else if(strToken[0].equals("empty")) {
				if(queue.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}else if(strToken[0].equals("pop")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(queue.poll());
				}
			}

		}
	}
}