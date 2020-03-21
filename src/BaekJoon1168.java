//Baekjoon - 1168

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.*;
public class BaekJoon1168 {
	
	private static final String PRE = "<";
	private static final String SPACE = ", ";
	private static final String POST = ">";

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken())-1;
		
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=1; i<N+1; i++) {
			arr.add(i);
		}
		
		int idx=  0;
		
		StringBuilder sb = new StringBuilder();
		sb.append(PRE);
		
		while(!arr.isEmpty()) {
			idx += M;
			
			idx %= arr.size();
			
			sb.append(arr.remove(idx)).append(SPACE);
		}
		System.out.println(sb.substring(0,sb.length()-2)+POST);
	}
}