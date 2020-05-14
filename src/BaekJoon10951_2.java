//Baekjoon - 10951
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
public class BaekJoon10951_2 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String value ="";
		
		while((value=br.readLine())!=null) {
			String[] strToken = value.split(" ");
			int sum = 0;
			for(String string: strToken) {
				sum += Integer.parseInt(string);
			}
			System.out.println(sum);
		}
	}
}

