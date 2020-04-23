//Baekjoon - 1107 리모컨
import java.io.*;
import java.util.*;

public class BaekJoon1107 {
	static boolean[] broken = new boolean[10];	//버튼이 망가져 있으면 true, 아니면 false
	public static int canMove(int channel) {	//가능하면 수의 길이를 리턴, 불가능하면 0을 리턴
		int length = 0;
		if(channel ==0)
			return broken[0] ? 0 : 1;
		
		while(channel > 0) {
			if(broken[channel % 10]) {
				return 0;
			}
			length +=1;
			channel /=10;
		}
		return length;
	}
	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[] arr = new int[M];
		for(int i=0; i<M; i++) {
			broken[scan.nextInt()] = true;	//버튼이 망가져 있으면 true, 아니면 false
		}
		
		//100에서 n까지 숫자 버튼을 누르지 않고, +와 -만을 눌러서 이동하는 코드
		int answer = Math.abs(N-100);
		
		// 채널은 무한대만큼 있지만 이동하려고 하는 채널 N의 범위가 0 ≤ N ≤ 500,000이므로 0번에서 500,000번으로 이동하는 횟수가 500,000이므로 
		//반대로 500,000 + 500,000 = 1,000,000까지만 구하면 됩니다.
		
		
		//이동할 채널 c를 결정한 다음, 가능하면 버튼을 총 몇 번 눌러야 하는지
		for(int i=0; i<=1000000; i++) {	//숫자 버튼으로 이동하는 채널
			int c = i;
			int length = canMove(c);	//길이를 잰다
			if(length > 0) {
				int press = Math.abs(c-N);
				answer = Math.min(answer, length+press);
			}
		}
		System.out.println(answer);
	}
}
