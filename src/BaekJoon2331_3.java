//Baekjoon - 2331_2
import java.io.*;
import java.math.*;
import java.util.*;

public class BaekJoon2331_3 {
	
	static int P;
	public static void main(String[] args)throws Exception{
		
		Scanner sc = new Scanner(System.in);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int A = sc.nextInt();
		P = sc.nextInt();
		
		map.put(A, 0);
		int cnt =1;
		int tmp = A;
		
		while(true) {
			int D = sum(tmp);
			if(map.containsKey(D)) {
				System.out.println(map.get(D));
				return;
			}
			map.put(D, cnt++);
			tmp = D;
			
		}
		
		
	}	
	public static int sum(int A) {
		int tmp = 0;
		while(A!=0) {
			tmp += (int) Math.pow(A%10, P);
			A /= 10;
		}
		return tmp;
	}
}