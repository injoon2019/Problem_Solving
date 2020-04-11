//Baekjoon - 10816 숫자 카드 2 
//https://jackpot53.tistory.com/33
import java.io.*;
import java.util.*;

public class BaekJoon10816 {

	static int[] d = new int[20000001];
	static final int HALF = 10000000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(n-- >0) {
			d[Integer.parseInt(st.nextToken())+HALF]++;
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		while(m-- >0) {
			bw.write((d[Integer.parseInt(st.nextToken())+HALF]+" "));
		}
		bw.close();
		br.close();
	}
}
