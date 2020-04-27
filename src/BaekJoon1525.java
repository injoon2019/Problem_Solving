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
		int start= 0;	//시작할 때 순열
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				int num = scan.nextInt();
				
				//빈 칸을 9로 표시
				//이유는 전체 배열을 아홉자리 숫자로 만들고싶은데
				//첫 칸이 0이면 그렇게 안되니까?
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
			//9가 나오는 위치를 찾고, x,y,의 위치를 찾는다
			//x,y의 위치를 찾은 뒤에 그 인덱스로 9의 값을 이동시킨다
			//이동시키면서 9가 우측 하단으로 갈 수 있도록 swap 해준다
			
			int nowNum = queue.poll();	// 현재 숫자: 193425786
			String now = String.valueOf(nowNum);
			int nine = now.indexOf('9');	//9가 있는 곳의 인덱스를 찾는다
			int y = nine/3;	//9가 있는 곳의 row
			int x = nine%3;	//9가 있는 곳의 column
			
			for(int i=0; i<4; i++) {
				int ny = y+ dy[i];
				int nx = x+ dx[i];
				
				if((nx>=0 && nx<3) && (ny>=0 && ny<3)) {
					//3*y+x일 때의 값과 ny*3+ ny의 값 위치 변경
					StringBuilder next = new StringBuilder(now);
					char temp = next.charAt(y*3+x);//이 전에 있던 것을 temp로 넣어두고
					next.setCharAt(y*3+x, (char)next.charAt(ny*3+nx));//ny*3+nx의 인덱스를 갖는 갚이 나오게 된다
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

