//Baekjoon - 1850
import java.io.*;
import java.math.BigInteger;

/*
 * x�� y�� �ִ������� gcd(x, y)��� �սô�.
"gcd((1�� a��), (1�� b��))�� (1�� gcd(a, b)��)�̴�"�� a+b�� ���� �ͳ������� ���� �� �ֽ��ϴ�.
a >= b��� �����մϴ�. �ƴ� ��� �� ���� �ٲ�ġ�� �˴ϴ�.
a=b�� ��쿡�� �ڸ��ϰ�, �� ���� base case�� a+b=2�� ��츦 �����մϴ�. ���� base case�� �����߽��ϴ�.
���� a+b=2, 3, ..., k���� ������ �����Ѵٰ� �����ϰ�, a+b=k+1�̶�� �սô�.
x>y�� �� gcd(x, y) = gcd(x-y, y)��� ������ �̿��մϴ�. (1�� a��)���� (1�� b��)�� ���� (1�� a-b��, 0�� b��)�� �˴ϴ�. 
�� gcd((1�� a��), (1�� b��)) = gcd((1�� a-b��, 0�� b��), (1�� b��))�Դϴ�.
�� �������� p�� y�� ���μ��� �� gcd(xp, y) = gcd(x, y)��� ������ �̿��մϴ�. 
10�� �ŵ������� (1�� b��)�� ���μ��̹Ƿ� gcd((1�� a-b��, 0�� b��), (1�� b��)) = gcd((1�� a-b��), (1�� b��))�Դϴ�.
�ͳ��� ������ ���� gcd((1�� a-b��), (1�� b��)) = (1�� gcd(a-b, b)��)�Դϴ�.
gcd(x, y) = gcd(x-y, y) ������ ���� (1�� gcd(a-b, b)��) = (1�� gcd(a, b)��)�Դϴ�. �̷ν� ������ ����Ǿ����ϴ�.
 * */
public class BaekJoon1850 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] strToken = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		long N = Long.parseLong(strToken[0]);
		long K = Long.parseLong(strToken[1]);

		BigInteger b1 = BigInteger.valueOf(N);
		BigInteger b2 = BigInteger.valueOf(K);
		BigInteger gcd = b1.gcd(b2);
		long ans = gcd.intValue();
		for(long i=0; i<ans; i++) {
			sb.append("1");
		}
		bw.append(sb);
		bw.flush();
	}
}