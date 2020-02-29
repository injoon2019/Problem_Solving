//Baekjoon - 10951
//입력은 여러 개의 테스트 케이스로 이루어져 있다.
//각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)

//(Java) BufferedReader.readLine()은 null을 반환합니다.
import java.io.*;
public class AplusB4 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String value = "";
		
		while((value = br.readLine()) !=null) {
			String[] strToken = value.split(" ");
			int sum = 0;
			
			for(String string : strToken) {
				sum+= Integer.parseInt(string);
			}
			
			System.out.println(sum);
		}
		
	}
}
