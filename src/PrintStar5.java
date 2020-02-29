//Baekjoon - 2445
import java.io.*;
public class PrintStar5 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N-1; i++) {
			for(int j=1; j<=i; j++) {
				sb.append("*");
			}
			for(int k=2*(N-i); k>0; k--) {
				sb.append(" ");
			}
			for(int j=1; j<=i; j++) {
				sb.append("*");
			}
			sb.append('\n');
		}
		
		for(int i=0; i<2*N; i++) {
			sb.append("*");
		}
		sb.append("\n");
		
		for(int i=1; i<=N-1; i++) {
			for(int j=1; j<=N-i; j++) {
				sb.append("*");
			}
			for(int j=1; j<=i*2; j++) {
				sb.append(" ");
			}
			for(int j=1; j<=N-i; j++) {
				sb.append("*");
			}
			sb.append('\n');
		}
		
		bw.append(sb);
		bw.flush();
	}	
}