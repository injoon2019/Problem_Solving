//Baekjoon - 10815 숫자 카드 
import java.io.*;
import java.util.*;

public class BaekJoon10815 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		Arrays.parallelSort(arr);

		int M = scan.nextInt();
		int[] test = new int[M];
		for (int i = 0; i < M; i++) {
			test[i] = scan.nextInt();
		}

		for (int i = 0; i < M; i++) {
			int left = 0;
			int right = N - 1;
			int mid = 0;
			boolean there = false;
			while (left <= right) {
				mid = (left + right) / 2;
				if (arr[mid] > test[i]) {
					right = mid - 1;
				} else if (arr[mid] < test[i]) {
					left = mid + 1;
				} else {
					there = true;
					break;
				}
			}
			if (there) {
				System.out.print("1 ");
			} else {
				System.out.print("0 ");
			}

		}
	}
}
