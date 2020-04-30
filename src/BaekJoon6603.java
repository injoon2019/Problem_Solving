//Baekjoon - 6603 ·Î¶Ç
//https://mygumi.tistory.com/191
import java.io.*;
import java.util.*;

public class BaekJoon6603 {
	static int k;
	static int[] array;
	static int cnt;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		while((k=sc.nextInt())!=0) {
			array = new int[13];
			
			for(int i=0; i<k; i++) {
				array[i] = sc.nextInt();
			}
			
			for(int i=0; i<k; i++) {
				cnt = 1;
				dfs(i, array[i]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int v, String str) {
		if(cnt==6) {
			sb.append(str+"\n");
		}else {
			for(int i=v+1; i<k; i++) {
				cnt++;
				dfs(i, str+array[i]+ " ");
			}
		}
		cnt--;
	}
}
