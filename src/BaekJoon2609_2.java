//Baekjoon - 2609 (최대공약수와 최소공배수)
import java.io.*;
import java.math.BigInteger;
/*
 * 유클리드 호제법은 GCD를 쉽게 구할 수 있는 알고리즘 중의 하나이다. 이 알고리즘은 식을 간결하게 해주는 특징이 있다. 
 * 두 수 a와 b (a > b)가 있다고 할 때, a와 b의 최대공약수 G는 b와 a%b(a를 b로 나눈 나머지)의 최대공약수 G'과 서로 같다!
예시 입력으로 보면,gcd(24, 18) = gcd(18, 6) = gcd(6, 0)인 것이다!
여기서 b가 0이 되는 순간의 6이 바로 최대공약수가 된다.

A와 B는 각각 x*gcd(a, b), y*gcd(a, b)이다. 따라서 A*B/gcd(a, b)를 해주면 최소공배수가 된다!
 * */
public class BaekJoon2609_2 {

	public static int getGCD(int N, int K) {
		if(K==0)
			return N;
		
		return getGCD(K, N%K);
	}
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken =  br.readLine().split(" ");
		int N = Integer.parseInt(strToken[0]);
		int K = Integer.parseInt(strToken[1]);
		
		int gcd = getGCD(N, K);
		System.out.println(gcd);
		System.out.println(N*K/gcd);
	}	
}