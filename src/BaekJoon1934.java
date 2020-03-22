//Baekjoon - 1934
import java.io.*;
import java.math.BigInteger;
/*
 * ��Ŭ���� ȣ������ GCD�� ���� ���� �� �ִ� �˰��� ���� �ϳ��̴�. �� �˰����� ���� �����ϰ� ���ִ� Ư¡�� �ִ�. 
 * �� �� a�� b (a > b)�� �ִٰ� �� ��, a�� b�� �ִ����� G�� b�� a%b(a�� b�� ���� ������)�� �ִ����� G'�� ���� ����!
���� �Է����� ����,gcd(24, 18) = gcd(18, 6) = gcd(6, 0)�� ���̴�!
���⼭ b�� 0�� �Ǵ� ������ 6�� �ٷ� �ִ������� �ȴ�.

A�� B�� ���� x*gcd(a, b), y*gcd(a, b)�̴�. ���� A*B/gcd(a, b)�� ���ָ� �ּҰ������ �ȴ�!
 * */
public class BaekJoon1934 {
	int GetGCD(int a, int b)
	{
		if (b == 0)
			return a;
		else
			return GetGCD(b, a%b);
	}
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			String[] strToken =  br.readLine().split(" ");
			int N = Integer.parseInt(strToken[0]);
			int K = Integer.parseInt(strToken[1]);
			
			BigInteger b1 = BigInteger.valueOf(N);
			BigInteger b2 = BigInteger.valueOf(K);
			BigInteger gcd = b1.gcd(b2);
			int ans  = gcd.intValue();
			System.out.println(N);
		}
		
	}	
}