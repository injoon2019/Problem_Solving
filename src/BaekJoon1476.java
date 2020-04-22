
//Baekjoon - 1476
import java.io.*;
import java.util.*;

public class BaekJoon1476 {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		int E = scan.nextInt(); // 1 ¡Â E ¡Â 15
		int S = scan.nextInt(); // 1 ¡Â S ¡Â 28
		int M = scan.nextInt(); // 1 ¡Â M ¡Â 19

		int e, s, m;
		int i = 1;
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
