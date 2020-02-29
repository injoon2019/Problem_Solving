import java.io.*;
class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		System.out.println(a+b);
		return;
	}
}


//import java.util.*;
//public class AplusB {
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int A = scanner.nextInt();
//		int B= scanner.nextInt();
//		System.out.println(A+B);
//	}
//}
