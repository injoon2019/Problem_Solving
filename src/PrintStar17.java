//Baekjoon - 10992
import java.io.*;
public class PrintStar17 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=N-1; i>=1; i--) {
			sb.append(" ");
		}
		sb.append("*").append('\n');
		
		
		for(int i=2; i<N; i++) {
			
			for(int k= N-i;  k>=1; k--) {
				sb.append(" ");
			}
			sb.append("*");
			
			for(int j=1; j<= (i-1)*2-1; j++) {
				sb.append(" ");
			}
			sb.append("*");
			sb.append("\n");
		}
		
		if(N!=1) {
			for(int i=1; i<=2*N-1; i++) {
				sb.append("*");
			}
		}

		
		bw.append(sb);
		bw.flush();
	}	
}