//Baekjoon - 2331_2
import java.io.*;
import java.math.*;
import java.util.*;

public class BaekJoon2331_2 {
	
	static int P;
	static int[] visit = new int[300000];
	
	public static int DFS(int num) {
		visit[num]++;
		
		if(visit[num]>=3)
			return 0;
	
		int temp = sum(num);
		DFS(temp);
		return 0;
	}
	public static void main(String[] args)throws Exception{
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		P = sc.nextInt();
		
		DFS(A);
		int count = 0;
		for(int i=0; i<300000; i++) {
			if(visit[i]==1) {
				count++;
			}
		}
		System.out.println(count);
		
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