//Baekjoon - 2580 스도쿠

import java.io.*;
import java.util.*;

class xy{	//입력된 스도쿠 판의 빈 칸의 행,열 정보를 저장
	int x,y;
	public xy(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BaekJoon2580 {
	
	static int[][] check = new int[9][9];
	//빈칸의  정보를 가지고 있는 객체를 저장할 ArrayList이다
	static ArrayList<xy> arrayList= new ArrayList<>();
	
	//DFS를 수행할 메소드이다. ArrayList와 인덱스 값을 인자로 전달받는다. 
	static void dfs(ArrayList<xy> arr, int idx) {
		
		if(idx == arrayList.size()) {	//재귀호출 종료 부
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(check[i][j]+" ");
				}
				System.out.println();
			}
			System.exit(0);	//여러가지 스도쿠 판을 출력하지 않게 프로그램 종료
		}
		
		for(int i=1; i<10; i++) {	//1~9까지 적합한지 유망성 검사하기 위한 반복
			
			//유망한 숫자를 고르기 위해 3가지 체크 메소드에 전달하여 검사
			if(checkRow(arr,idx,i)==true && checkCol(arr,idx,i)==true && checkBox(arr,idx,i)==true) {
				check[arr.get(idx).x][arr.get(idx).y]= i;
				dfs(arr, idx+1);
			}
			
			//i가 9인채로 반복문이 종료하게되면 이전에 저장되었떤 번호를 지운 후 새로운 스도쿠 판 생성
			if(i==9)
				check[arr.get(idx).x][arr.get(idx).y] = 0;
		}
	}
	
	//스도쿠에서 빈칸이 포함되어 있는 가로행에 중복검사
	static boolean checkRow(ArrayList<xy> arr, int idx, int pro) {
		for(int i=0; i<9; i++) {	//가로행의 0~8번 인덱스를 검사
			if(arr.get(idx).y == i)	//빈칸의 열은 건너뛴다
				continue;
			
			//후보로 전달 된 정수가 이미 스도쿠 판에 존재하는 숫자와 일치하면
			//유망하지 않은 정수이므로 false 리턴
			if(check[arr.get(idx).x][i]==pro)
				return false;
		}
		return true;
	}
	
	//스도쿠에서 빈칸이 포함되어 있는 세로열에 중복검사
	static boolean checkCol(ArrayList<xy> arr, int idx, int pro) {
		for(int i=0; i<9; i++) {	//세트열에 0~8번 인덱스를 검사
			if(arr.get(idx).x == i) continue;
			
			//후보로 전달된 젖ㅇ수가 이미 스도쿠 판에 존재하는 숫자와 일치하면
			//유망하지 않은 정수이므로 false 리턴
			if(check[i][arr.get(idx).y]==pro)
				return false;
		}
		return true;
	}
	
	//3X3박스에서 중복 검사
	static boolean checkBox(ArrayList<xy> arr, int idx, int pro) {
		int a = arr.get(idx).x/3;
		int b = arr.get(idx).y/3;
		
		//시작점의 박스를 구하고, 3을 곱해서 시작점 좌표를 구하는 것
		a*=3;
		b*=3;
		
		for(int i=a; i<a+3; i++) {
			for(int j=b; j<b+3; j++) {
				//빈칸의 좌표 스킵
				if(i==arr.get(idx).x && j == arr.get(idx).y)
					continue;
				
				//이미 수도쿠 판에 잇는 숫자이면 false
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
		
		/*2차원 배열로 구현 후 입력을 받아 저장하고, 한 번 탐색을 통해 현재 스도쿠판의 빈칸인 행, 열 좌표를 객체화하여 ArrayList에 별도로 저장해 둔다.
		 *  이런 방식을 사용하는 이유는 재귀호출을 반복할 때마다 스도쿠 판에서 빈칸을 찾는 방식을 사용하게 되면 
		 *  당연하게도 시간제한인 1초를 넘기게 될 것이다. 그렇기 때문에 미리 빈 칸을 저장해 별도의 배열 형태로 저장해 두면 
		 *  해당 배열에 저장되어 있는 행, 열 값만을 처리해주면 된다.
		 * */
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(check[i][j]==0) {
					arrayList.add(new xy(i,j));
				}
			}
		}
		
		dfs(arrayList, 0);	//ArrayList와 함께 0번째 인덱스부터 스도쿠판을 채워간다

	}	
}