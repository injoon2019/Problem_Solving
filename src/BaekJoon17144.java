//Baekjoon - 17144 �̼����� �ȳ�!

import java.io.*;
import java.util.*;
public class BaekJoon17144 {

	static int[][] arr;
	static int[][] copyArr;
	static boolean[][] visited;
	static int[] x = {-1, 0, 0, 1};
	static int[] y = { 0, 1,-1, 0}; 
	static int R, C;
	static int upAir, downAir;
	
	public static void main(String[] args)throws Exception{
		Scanner scan = new Scanner(System.in);
		R = scan.nextInt();
		C = scan.nextInt();
		int T = scan.nextInt();
		
		arr = new int[R][C];
		copyArr = new int[R][C];
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				arr[i][j] = scan.nextInt();
				copyArr[i][j] = arr[i][j];
				if(arr[i][j]==-1) {
					if(upAir==0) {
						upAir=i;
					}else {
						downAir=i;
					}
				}
			}
		}
		for(int i=0; i<T; i++) {
			diffusion();
			airCleaner();
			arrayCopy();
		}
		
//		for(int i=0; i<R; i++) {
//			for(int j=0; j<C; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(getSum());
	}
	
	public static void diffusion() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				int possibleBlock = count(i,j);
				for(int k=0; k<4; k++) {
					int ny = i+y[k];
					int nx = j+x[k];
					if(nx>=0 && nx<C && ny>=0 && ny<R && copyArr[ny][nx]!= -1) {
						arr[ny][nx] += copyArr[i][j]/5;
					}
				}
				arr[i][j] = arr[i][j]- (copyArr[i][j]/5)*possibleBlock;
			}
		}
	}
	
	//������ �� �ִ� ������ ������ �����ִ� �Լ� 
	public static int count(int i, int j) {
		int count=0;
		for(int k=0; k<4; k++) {
			int ny = i+y[k];
			int nx = j+x[k];
			if(nx>=0 && nx<C && ny>=0 && ny<R && copyArr[ny][nx]!= -1) {
				count++;
			}
		}
		return count;
	}
	
	//ó������ �׳� for loop �� ���ȴµ� �׷����ϸ� ���ÿ� ������ ���� �ƴ϶�
	//for loop �������� ������ �ڵ尡 ������ �ڵ忡 ������ �ְԵȴ�. (���������� �ʴ�)
	public static void arrayCopy() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				copyArr[i][j] = arr[i][j];
			}
		}
	}
	
	public static void airCleaner() {
		//�� �κ� �����ȯ
		//ȭ��ǥ ���������� ��ĭ�� �����
		for(int i=upAir-1; i>0; i--) {
			arr[i][0] = arr[i-1][0];
		}
		
		for(int j=0; j<C-1;j++) {
			arr[0][j] = arr[0][j+1];
		}
		
		for(int i=0; i<upAir;i++) {
			arr[i][C-1] = arr[i+1][C-1];
		}
		
		for(int j=C-1; j>0; j--) {
			arr[upAir][j] = arr[upAir][j-1];
		}
		arr[upAir][1]=0;
		//�Ʒ� �κ� �����ȯ 
		for(int i=downAir+1;i<R-1;i++) {
			arr[i][0] = arr[i+1][0];
		}
		
		for(int j=0; j<C-1; j++) {
			arr[R-1][j] = arr[R-1][j+1];
		}
		
		for(int i=R-1; i>downAir; i--) {
			arr[i][C-1]=arr[i-1][C-1];
		}
		
		for(int j=C-1; j>0; j--) {
			arr[downAir][j] = arr[downAir][j-1];
		}
		arr[downAir][1]=0;
	}
	
	public static int getSum() {
		int sum = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j]==-1)
					continue;
				else
					sum+=arr[i][j];
			}
		}
		return sum;
	}
}

