//Baekjoon - 2580 ������

import java.io.*;
import java.util.*;

class xy{	//�Էµ� ������ ���� �� ĭ�� ��,�� ������ ����
	int x,y;
	public xy(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BaekJoon2580 {
	
	static int[][] check = new int[9][9];
	//��ĭ��  ������ ������ �ִ� ��ü�� ������ ArrayList�̴�
	static ArrayList<xy> arrayList= new ArrayList<>();
	
	//DFS�� ������ �޼ҵ��̴�. ArrayList�� �ε��� ���� ���ڷ� ���޹޴´�. 
	static void dfs(ArrayList<xy> arr, int idx) {
		
		if(idx == arrayList.size()) {	//���ȣ�� ���� ��
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(check[i][j]+" ");
				}
				System.out.println();
			}
			System.exit(0);	//�������� ������ ���� ������� �ʰ� ���α׷� ����
		}
		
		for(int i=1; i<10; i++) {	//1~9���� �������� ������ �˻��ϱ� ���� �ݺ�
			
			//������ ���ڸ� ���� ���� 3���� üũ �޼ҵ忡 �����Ͽ� �˻�
			if(checkRow(arr,idx,i)==true && checkCol(arr,idx,i)==true && checkBox(arr,idx,i)==true) {
				check[arr.get(idx).x][arr.get(idx).y]= i;
				dfs(arr, idx+1);
			}
			
			//i�� 9��ä�� �ݺ����� �����ϰԵǸ� ������ ����Ǿ��� ��ȣ�� ���� �� ���ο� ������ �� ����
			if(i==9)
				check[arr.get(idx).x][arr.get(idx).y] = 0;
		}
	}
	
	//�������� ��ĭ�� ���ԵǾ� �ִ� �����࿡ �ߺ��˻�
	static boolean checkRow(ArrayList<xy> arr, int idx, int pro) {
		for(int i=0; i<9; i++) {	//�������� 0~8�� �ε����� �˻�
			if(arr.get(idx).y == i)	//��ĭ�� ���� �ǳʶڴ�
				continue;
			
			//�ĺ��� ���� �� ������ �̹� ������ �ǿ� �����ϴ� ���ڿ� ��ġ�ϸ�
			//�������� ���� �����̹Ƿ� false ����
			if(check[arr.get(idx).x][i]==pro)
				return false;
		}
		return true;
	}
	
	//�������� ��ĭ�� ���ԵǾ� �ִ� ���ο��� �ߺ��˻�
	static boolean checkCol(ArrayList<xy> arr, int idx, int pro) {
		for(int i=0; i<9; i++) {	//��Ʈ���� 0~8�� �ε����� �˻�
			if(arr.get(idx).x == i) continue;
			
			//�ĺ��� ���޵� �������� �̹� ������ �ǿ� �����ϴ� ���ڿ� ��ġ�ϸ�
			//�������� ���� �����̹Ƿ� false ����
			if(check[i][arr.get(idx).y]==pro)
				return false;
		}
		return true;
	}
	
	//3X3�ڽ����� �ߺ� �˻�
	static boolean checkBox(ArrayList<xy> arr, int idx, int pro) {
		int a = arr.get(idx).x/3;
		int b = arr.get(idx).y/3;
		
		//�������� �ڽ��� ���ϰ�, 3�� ���ؼ� ������ ��ǥ�� ���ϴ� ��
		a*=3;
		b*=3;
		
		for(int i=a; i<a+3; i++) {
			for(int j=b; j<b+3; j++) {
				//��ĭ�� ��ǥ ��ŵ
				if(i==arr.get(idx).x && j == arr.get(idx).y)
					continue;
				
				//�̹� ������ �ǿ� �մ� �����̸� false
				if(check[i][j]!=0 && check[i][j]==pro)
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			String[] strToken = br.readLine().split(" ");
			for(int j=0; j<9; j++) {
				check[i][j] = Integer.parseInt(strToken[j]);
			}
		}
		
		/*2���� �迭�� ���� �� �Է��� �޾� �����ϰ�, �� �� Ž���� ���� ���� ���������� ��ĭ�� ��, �� ��ǥ�� ��üȭ�Ͽ� ArrayList�� ������ ������ �д�.
		 *  �̷� ����� ����ϴ� ������ ���ȣ���� �ݺ��� ������ ������ �ǿ��� ��ĭ�� ã�� ����� ����ϰ� �Ǹ� 
		 *  �翬�ϰԵ� �ð������� 1�ʸ� �ѱ�� �� ���̴�. �׷��� ������ �̸� �� ĭ�� ������ ������ �迭 ���·� ������ �θ� 
		 *  �ش� �迭�� ����Ǿ� �ִ� ��, �� ������ ó�����ָ� �ȴ�.
		 * */
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(check[i][j]==0) {
					arrayList.add(new xy(i,j));
				}
			}
		}
		
		dfs(arrayList, 0);	//ArrayList�� �Բ� 0��° �ε������� ���������� ä������

	}	
}