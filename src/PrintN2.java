//Baekjoon - 2742
import java.io.*;
public class PrintN2{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n= Integer.parseInt(br.readLine());
		
		for(int i=n; i>=1; i--) {
			sb.append(i).append('\n');
		}
		bw.append(sb);
		bw.flush();
	}
}




//import java.io.*;
//public class PrintN {
//	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int N = Integer.parseInt(br.readLine());
//		for(int i=0; i<N; i++) {
//			System.out.println(i+1);
//		}
//	}
//}
