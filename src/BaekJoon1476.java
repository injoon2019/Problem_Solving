
//Baekjoon - 1476
import java.io.*;
import java.util.*;

public class BaekJoon1476 {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		int E = scan.nextInt(); // 1 ≤ E ≤ 15
		int S = scan.nextInt(); // 1 ≤ S ≤ 28
		int M = scan.nextInt(); // 1 ≤ M ≤ 19

		int e, s, m;
		int i = 1;
		//15, 28, 19 모두 서로소다.
		//그래서 사실 가능한 경우의 수는 15x28x19다
		while (true) {
			if (i % 15 == 0) {
				e = 15;
			} else {
				e = (i % 15);
			}
			if (i % 28 == 0) {
				s = 28;
			} else {
				s = (i % 28);
			}
			if (i % 19 == 0) {
				m = 19;
			} else {
				m = (i % 19);
			}
			if (E == e && S == s && M == m) {
				System.out.println(i);
				break;
			}
			i++;
		}
	}
}
