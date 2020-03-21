//Baekjoon - 1158

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.*;
public class BaekJoon1158 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken = br.readLine().split(" ");
		int N = Integer.parseInt(strToken[0]);
		int K = Integer.parseInt(strToken[1]);
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0;  i<N; i++) {
			queue.add(i+1);
		}
		System.out.printf("<");
		while(!queue.isEmpty()) {
			for(int i=0; i<K-1; i++) {
				queue.add(queue.poll());
			}
			if(queue.size()>1)
				System.out.printf("%d, ", queue.poll());
			else if (queue.size()==1)
				System.out.printf("%d>\n", queue.poll());
		}
		
	}
}