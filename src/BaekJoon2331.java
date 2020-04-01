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
		/*HashMap에 (구한 D 값, 몇번 째 들어온 수인지) 로 입력
		 * D를 구하고 만약 기존 맴에 있던 값이면 그 값의 data를 출력후 리턴
		 * */
		while(true) {
			int D = 0;
			while(tmp != 0) {	//다음 D 구하기
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