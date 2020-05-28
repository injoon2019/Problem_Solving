//Baekjoon - 1158

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.*;
public class BaekJoon1158_2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken = br.readLine().split(" ");
		int N = Integer.parseInt(strToken[0]);
		int K = Integer.parseInt(strToken[1]);
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		int index=1;
		System.out.print("<");
		while(!queue.isEmpty()) {
			for(int i=0; i<K-1; i++) {
				queue.add(queue.poll());
			}
			if(queue.size()>1) {
				System.out.printf("%d, ", queue.poll());
			}
			else if (queue.size()==1) {
				System.out.printf("%d>", queue.poll());
			}
		}
	}
}