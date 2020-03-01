//Baekjoon - 10991
import java.io.*;
public class PrintStar16 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			for(int k=N-i; k>=1; k--) {
				sb.append(" ");
			}
			
			for(int j=1; j<=i; j++) {
				sb.append("*").append(" ");
			}
			sb.append('\n');
		}

		
		bw.append(sb);
		bw.flush();
	}	
}