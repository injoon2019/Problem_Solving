//Baekjoon - 2609 (�ִ������� �ּҰ����)
import java.io.*;
import java.math.BigInteger;
/*
 * ��Ŭ���� ȣ������ GCD�� ���� ���� �� �ִ� �˰��� ���� �ϳ��̴�. �� �˰����� ���� �����ϰ� ���ִ� Ư¡�� �ִ�. 
 * �� �� a�� b (a > b)�� �ִٰ� �� ��, a�� b�� �ִ����� G�� b�� a%b(a�� b�� ���� ������)�� �ִ����� G'�� ���� ����!
���� �Է����� ����,gcd(24, 18) = gcd(18, 6) = gcd(6, 0)�� ���̴�!
���⼭ b�� 0�� �Ǵ� ������ 6�� �ٷ� �ִ������� �ȴ�.

A�� B�� ���� x*gcd(a, b), y*gcd(a, b)�̴�. ���� A*B/gcd(a, b)�� ���ָ� �ּҰ������ �ȴ�!
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