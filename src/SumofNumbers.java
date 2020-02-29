//Baekjoon - 11720
import java.io.*;
public class SumofNumbers {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int sum =0;
		String str = br.readLine();
		for(int i=0; i<N; i++)
		{
			sum += str.charAt(i)-'0';
		}
		System.out.println(sum);		
	}

	
}
