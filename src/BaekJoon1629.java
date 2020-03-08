//Baekjoon - 1629

import java.io.*;
public class BaekJoon1629 {
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strToken = br.readLine().split(" ");
		long A, B, C;
		A= Long.parseLong(strToken[0]);
		B= Long.parseLong(strToken[1]);
		C= Long.parseLong(strToken[2]);
		long result= cal(A,B,C);
		System.out.println(result);
	}	
	
	//Repeated Squaring algorithm 참고할 것 
	//A를 B번 곱한 수를 나눈 나머지 값을 구해야 한다. 
	public static long cal(long A, long B, long C) {
		long tmp = 0;
		// A^4 = A^2 * A^2 ;
		//A^5 =  A* A^2 * A^2;
		if(B==1)
			return A%C;
		if(B==0)
			return 1;
		if(B%2 == 0) {
			tmp = cal(A,B/2, C);
			return (tmp * tmp) %C;
		}else {
			tmp = cal(A, (B-1)/2, C);
			long tmp2 = (tmp* tmp) %C ;
			return  (A* tmp2) % C;
		}
	}
}