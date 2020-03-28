//Baekjoon - 2004
//https://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class BaekJoon2004 {

	public static int Count(int n, int d) {
		int count=0;
		while(n >=d) {
			n = n/d;
			count += n;
		}
		return count;
	}

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken  = br.readLine().split(" ");
		int n = Integer.parseInt(strToken[0]);
		int m = Integer.parseInt(strToken[1]);
		
		int n_f = Count(n,5);
		int n_t = Count(n,2);
		
		int m_f = Count(m,5);
		int m_t = Count(m,2);
		int n_m_f = Count(n-m,5);
		int n_m_t = Count(n-m,2);
		int two = n_t - m_t -n_m_t;
		int five = n_f - m_f - n_m_f;
		
		System.out.println(Math.min(two, five));

	}	
}