//Baekjoon - 1525
import java.io.*;
import java.util.*;
public class BaekJoon1525 {
	
	private static int[] dx = {-1,0,0,1};
	private static int[] dy = {0,-1,1,0};
	private static Queue<Integer> queue;
	private static int[] dist;
	private static final int MAX=10001;
	private static String puzzleAns;
	private static HashMap<Integer, Integer> map;
	
	public static void main(String[] args)throws Exception{
		Scanner scan = new Scanner(System.in);
		int start= 0;	//������ �� ����
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				int num = scan.nextInt();
				
				//�� ĭ�� 9�� ǥ��
				//������ ��ü �迭�� ��ȩ�ڸ� ���ڷ� ����������
				//ù ĭ�� 0�̸� �׷��� �ȵǴϱ�?
				if(num==0)
					num=9;
				start = start*10+num;			
			}
		}
		
		queue = new LinkedList<>();
		map = new HashMap<Integer, Integer>();
		
		queue.add(start);
		map.put(start, 0);
		
		while(!queue.isEmpty()) {
			//9�� ������ ��ġ�� ã��, x,y,�� ��ġ�� ã�´�
			//x,y�� ��ġ�� ã�� �ڿ� �� �ε����� 9�� ���� �̵���Ų��
			//�̵���Ű�鼭 9�� ���� �ϴ����� �� �� �ֵ��� swap ���ش�
			
			int nowNum = queue.poll();	// ���� ����: 193425786
			String now = String.valueOf(nowNum);
			int nine = now.indexOf('9');	//9�� �ִ� ���� �ε����� ã�´�
			int y = nine/3;	//9�� �ִ� ���� row
			int x = nine%3;	//9�� �ִ� ���� column
			
			for(int i=0; i<4; i++) {
				int ny = y+ dy[i];
				int nx = x+ dx[i];
				
				if((nx>=0 && nx<3) && (ny>=0 && ny<3)) {
					//3*y+x�� ���� ���� ny*3+ ny�� �� ��ġ ����
					StringBuilder next = new StringBuilder(now);
					char temp = next.charAt(y*3+x);//�� ���� �ִ� ���� temp�� �־�ΰ�
					next.setCharAt(y*3+x, (char)next.charAt(ny*3+nx));//ny*3+nx�� �ε����� ���� ���� ������ �ȴ�
					next.setCharAt(ny*3+nx, temp); 
					
					int num = Integer.parseInt(next.toString());
					if(!map.containsKey(num)) {
						map.put(num, map.get(nowNum)+1);
						queue.add(num);
					}
					
				}
			}
		}
		if(map.containsKey(123456789)) {
			System.out.println(map.get(123456789));
		}else {
			System.out.println("-1");
		}
	}
}

