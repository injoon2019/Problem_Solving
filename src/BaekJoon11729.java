//Baekjoon - 11729 하노이의 탑 이동 순서 
import java.io.*;
import java.util.*;

public class BaekJoon11729 {
	
	public static Stack<Integer> b1;
	public static Stack<Integer> b2;
	public static Stack<Integer> b3;
	public static StringBuilder sb;
	public static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		b1 = new Stack<>();
		b2 = new Stack<>();
		b3 = new Stack<>();
		count=0;
		for(int i=N; i>0; i--) {
			b1.add(i);
		}
		hanoi(N, b1, b2, b3);
		System.out.println(count);
		bw.append(sb);
		bw.flush();
	}

	static void hanoi(int n, Stack<Integer> from, Stack<Integer> by, Stack<Integer> to) {
		if(n==1)	//종료조건
			move(from, to);	//실제로 옮김
		else {
			hanoi(n-1, from, to, by);
			move(from, to);
			hanoi(n-1, by, from, to);
		}
	}
	
	static void move(Stack<Integer> from, Stack<Integer> to) {
		if(from == b1) {
			sb.append("1 ");
		}else if(from==b2) {
			sb.append("2 ");
		}else if(from==b3) {
			sb.append("3 ");
		}
		
		if(to == b1) {
			sb.append("1");
		}else if(to==b2) {
			sb.append("2");
		}else if(to==b3) {
			sb.append("3");
		}
		sb.append("\n");
		to.add(from.pop());
		count++;
	}
}
