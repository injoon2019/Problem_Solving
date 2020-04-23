//Baekjoon - 1107 ������
import java.io.*;
import java.util.*;

public class BaekJoon1107 {
	static boolean[] broken = new boolean[10];	//��ư�� ������ ������ true, �ƴϸ� false
	public static int canMove(int channel) {	//�����ϸ� ���� ���̸� ����, �Ұ����ϸ� 0�� ����
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
			broken[scan.nextInt()] = true;	//��ư�� ������ ������ true, �ƴϸ� false
		}
		
		//100���� n���� ���� ��ư�� ������ �ʰ�, +�� -���� ������ �̵��ϴ� �ڵ�
		int answer = Math.abs(N-100);
		
		// ä���� ���Ѵ븸ŭ ������ �̵��Ϸ��� �ϴ� ä�� N�� ������ 0 �� N �� 500,000�̹Ƿ� 0������ 500,000������ �̵��ϴ� Ƚ���� 500,000�̹Ƿ� 
		//�ݴ�� 500,000 + 500,000 = 1,000,000������ ���ϸ� �˴ϴ�.
		
		
		//�̵��� ä�� c�� ������ ����, �����ϸ� ��ư�� �� �� �� ������ �ϴ���
		for(int i=0; i<=1000000; i++) {	//���� ��ư���� �̵��ϴ� ä��
			int c = i;
			int length = canMove(c);	//���̸� ���
			if(length > 0) {
				int press = Math.abs(c-N);
				answer = Math.min(answer, length+press);
			}
		}
		System.out.println(answer);
	}
}
