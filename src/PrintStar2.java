//Baekjoon - 2439
import java.io.*;
public class PrintStar2 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			for(int j=N-i; j>=1; j--) {
				sb.append(" ");
			}
			for(int k=0; k<i; k++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		bw.append(sb);
		bw.flush();
	}	
}