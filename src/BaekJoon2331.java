//Baekjoon - 2331
import java.io.*;
import java.util.*;

public class BaekJoon2331 {
	static int P;

	public static void main(String[] args)throws Exception{
		
		Scanner sc = new Scanner(System.in);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int A = sc.nextInt();
		int P = sc.nextInt();
		
		map.put(A,0);
		int cnt =1;
		int tmp = A;
		/*HashMap�� (���� D ��, ��� ° ���� ������) �� �Է�
		 * D�� ���ϰ� ���� ���� �ɿ� �ִ� ���̸� �� ���� data�� ����� ����
		 * */
		while(true) {
			int D = 0;
			while(tmp != 0) {	//���� D ���ϱ�
				D+=Math.pow(tmp%10, P);
				tmp /=10;
			}
			if(map.containsKey(D)) {
				System.out.println(map.get(D));
				return;
			}
			map.put(D, cnt++);
			tmp = D;
		}
		
	}	
}