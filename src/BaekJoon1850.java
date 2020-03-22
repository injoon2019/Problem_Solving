//Baekjoon - 1850
import java.io.*;
import java.math.BigInteger;

/*
 * x와 y의 최대공약수를 gcd(x, y)라고 합시다.
"gcd((1이 a개), (1이 b개))는 (1이 gcd(a, b)개)이다"를 a+b에 대한 귀납법으로 보일 수 있습니다.
a >= b라고 가정합니다. 아닌 경우 두 수를 바꿔치면 됩니다.
a=b인 경우에는 자명하고, 이 경우는 base case인 a+b=2의 경우를 포함합니다. 따라서 base case를 증명했습니다.
이제 a+b=2, 3, ..., k까지 명제가 성립한다고 가정하고, a+b=k+1이라고 합시다.
x>y일 때 gcd(x, y) = gcd(x-y, y)라는 성질을 이용합니다. (1이 a개)에서 (1이 b개)를 빼면 (1이 a-b개, 0이 b개)가 됩니다. 
즉 gcd((1이 a개), (1이 b개)) = gcd((1이 a-b개, 0이 b개), (1이 b개))입니다.
그 다음에는 p와 y가 서로소일 때 gcd(xp, y) = gcd(x, y)라는 성질을 이용합니다. 
10의 거듭제곱은 (1이 b개)와 서로소이므로 gcd((1이 a-b개, 0이 b개), (1이 b개)) = gcd((1이 a-b개), (1이 b개))입니다.
귀납적 가정에 의해 gcd((1이 a-b개), (1이 b개)) = (1이 gcd(a-b, b)개)입니다.
gcd(x, y) = gcd(x-y, y) 성질에 의해 (1이 gcd(a-b, b)개) = (1이 gcd(a, b)개)입니다. 이로써 명제가 증명되었습니다.
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