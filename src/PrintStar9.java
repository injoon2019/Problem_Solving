//Baekjoon - 2466
import java.io.*;
public class PrintStar9 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			for(int k=1; k<i; k++) {
				sb.append(" ");
			}
			
			for(int j=1; j<= (N-i)*2+1;j++) {
				sb.append("*");
			}
			sb.append('\n');
		}
		
		for(int i=1; i<N; i++) {
			
			for(int k=1; k<=N-i-1; k++) {
				sb.append(" ");
			}
			
			for(int j=1; j<=2*i+1; j++) {
				sb.append("*");
			}
			sb.append('\n');
		}
		
		bw.append(sb);
		bw.flush();
	}	
}