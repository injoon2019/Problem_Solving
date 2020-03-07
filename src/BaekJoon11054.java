//Baekjoon - 11054
//https://sihyungyou.github.io/baekjoon-11054/
//https://fbtmdwhd33.tistory.com/56
import java.util.*;

public class BaekJoon11054 {
	static int n;

	static int dp[][], cost[]; // 메모이제이션 배열을 2차원 배열로 선언하여 LIS, LDS를 수행

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		dp = new int[2][n + 1];
		cost = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			cost[i] = sc.nextInt();
		}

		dp[1][n] = 1; // 오른쪽에서 시작하는 LIS
		dp[0][1] = 1; // 왼쪽에서 시작하는 LIS
		for (int i = n - 1; i > 0; i--) { // 오른쪽에서 시작하는 LIS
			dp[1][i] = 1;
			for (int j = n; j > i; j--) {
				if (cost[i] > cost[j]) {
					dp[1][i] = Math.max(dp[1][i], dp[1][j] + 1);
				}
			}
		}

		for (int i = 2; i <= n; i++) { // 왼쪽에서 시작하는 LIS
			dp[0][i] = 1;
			for (int j = 1; j < i; j++) {
				if (cost[i] > cost[j]) {
					dp[0][i] = Math.max(dp[0][i], dp[0][j] + 1);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) { // 두 배열의 값들을 더해준다.
			dp[0][i] += dp[1][i];

		}

		for (int i = 1; i <= n; i++) {
			if (dp[0][i] > max) {
				max = dp[0][i];
			}
		}

		System.out.println(max - 1); // 최댓값을 찾아 -1 해주면 정답

	}

}