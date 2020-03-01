//Baekjoon - 2522
import java.io.*;
public class PrintStar12 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<N; i++) {
			for(int k=N-i; k>=1; k--) {
				sb.append(" ");
			}
			
			for(int j=1; j<=i; j++) {
				sb.append("*");
			}
			sb.append('\n');
		}
		
		for(int i=1; i<=N; i++) {
			sb.append('*');
		}
		sb.append('\n');
		
		for(int i=1; i<N; i++) {
			
			for(int j=1; j<=i; j++) {
				sb.append(" ");
			}
			
			for(int k=N-i; k>=1; k--) {
				sb.append("*");
			}
			sb.append('\n');
		}
		
		bw.append(sb);
		bw.flush();
	}	
}