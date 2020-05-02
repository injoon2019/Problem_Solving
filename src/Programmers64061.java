//Baekjoon - 64061 (2019 카카오 개발자 겨울 인턴쉽 - 크레인 인형뽑기 게임)
import java.io.*;
import java.util.*;

public class Programmers64061 {
    static Stack<Integer> stack = new Stack<>();
    static int answer = 0; //터트러져 사라진 인형의 개수
	static int[][] board;
	static int[] moves;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken;
		
		board = new int[5][5];
		for(int i=0; i<5; i++) {
			strToken = br.readLine().split(" ");
			for(int j=0; j<5; j++) {
				board[i][j] = Integer.parseInt(strToken[j]);
			}
		}

		moves = new int[8];
		strToken = br.readLine().split(" ");
		for(int i=0; i<8; i++) {
			moves[i] = Integer.parseInt(strToken[i]);
		}
		
        //각 col에 몇 개씩 남았는가 저장하기 위한 배열
        int col = board[0].length;
        int row = board.length;
        int[] left = new int[col];
        
        for(int j=0; j<col; j++){
            int sum=0;
            for(int i=0; i<row; i++){
                if(board[i][j]>0) {
                	sum++;
                }
            }
            left[j] = sum;
            //System.out.print(left[j]+" ");
        }
        
        for(int i=0; i<moves.length; i++){
        	int p =0;
        	if(left[moves[i]-1]>0) {
        		p =pick(board, row-left[moves[i]-1], moves[i]-1);
        		left[moves[i]-1]--;
        	}
        		
            if(p==0)
            	continue;
            
            put(p);
        }
        System.out.println(answer);
		
	}	
	
    public static void put(int p){	
    	if(!stack.isEmpty()) {
    		int prev = stack.peek();
    		if(prev == p ){
                stack.pop();
                answer +=2;
                return;
            }
    	}
        stack.push(p);
        
    }
    public static int pick(int[][] board, int y, int x){
        int temp = board[y][x];
        board[y][x]=0;
        return temp;
    }
	
}