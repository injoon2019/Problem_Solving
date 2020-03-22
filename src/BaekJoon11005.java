//Baekjoon - 11005
import java.io.*;
import java.math.BigInteger;

public class BaekJoon11005 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] strToken = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(strToken[0]);
		int B = Integer.parseInt(strToken[1]);
	
		char[] arr = new char[37];
		for(int i=0; i<26; i++) {
			arr[i+10] = (char) (65+i) ;
		}
		while(N!=0) {
			if(N%B>=10) {
				sb.append(arr[N%B]);
			}else {
				sb.append(N%B);
			}
			
			N /=B;
		}
		
		for(int i=sb.length()-1; i>=0; i--) {
			System.out.printf("%c", sb.charAt(i));
		}
	}
}