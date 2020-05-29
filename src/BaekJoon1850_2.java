//Baekjoon - 1850_2
import java.io.*;
import java.math.BigInteger;

public class BaekJoon1850_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] strToken = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		long N = Long.parseLong(strToken[0]);
		long K = Long.parseLong(strToken[1]);

		
		BigInteger b1 = BigInteger.valueOf(N);
		BigInteger b2 = BigInteger.valueOf(K);
		BigInteger gcd = b1.gcd(b2);
		long ans = gcd.longValue();
		
		for(int i=0; i<ans; i++) {
			
		}
		for(long i=0; i<ans; i++) {
			sb.append("1");
		}
		bw.append(sb);
		bw.flush();
	}
}