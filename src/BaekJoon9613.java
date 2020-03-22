//Baekjoon - 9613
import java.io.*;
import java.math.BigInteger;

public class BaekJoon9613 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String[] strToken;
		int n;
		long sum=0;
		for(int i=0; i<t; i++) {
			strToken = br.readLine().split(" ");
			n = Integer.parseInt(strToken[0]);
			sum=0;
			int[] arr = new int[n];
			for(int k =0; k<n; k++) {
				arr[k]= Integer.parseInt(strToken[k+1]);
			}
			
			for(int k=0; k<n-1; k++) {
				for(int j=k+1; j<n; j++) {
					BigInteger b1 = BigInteger.valueOf(arr[k]);
					BigInteger b2 = BigInteger.valueOf(arr[j]);
					BigInteger gcd = b1.gcd(b2);
					long ans = gcd.intValue();
					sum+=ans;
				}
			}
			sb.append(sum).append('\n');
		}
		
		bw.append(sb);
		bw.flush();
	}
}