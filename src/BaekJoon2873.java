//Baekjoon - 2873 롤러코스터 
//https://dundung.tistory.com/45
import java.io.*;
import java.util.*;

public class BaekJoon2873 {
	
	public static void append(StringBuilder s, char c, int cnt) {	//cnt만큼 스트링 빌더에 char c를 삽입하는 메소드
		for(int i=0; i<cnt; i++) {
			s.append(c);
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] strToken = br.readLine().split(" ");
        int R = Integer.parseInt(strToken[0]);
        int C = Integer.parseInt(strToken[1]);
        int[][] map = new int[R][C];
        
        for(int i=0; i<R; i++) {
        	strToken = br.readLine().split(" ");
        	for(int j=0; j<C; j++) {
        		map[i][j] = Integer.parseInt(strToken[j]);
        	}
        }
        
        //R 또는 C가 홀수이면 모든 칸을 방문할 수 있다. 
        //R과 C 모두 짝수이면 모든 칸을 방문하는 것은 불가능 
        
        StringBuilder s = new StringBuilder();
        if(R%2==1) {//R이 홀수인 경우
        	for(int i=0; i<R; i++) {
        		if(i%2==0) {
        			append(s, 'R', C-1);
        			if(i!=R-1) {
        				append(s,'D',1);
        			}
        		}else {
        			append(s,'L',C-1);
        			append(s,'D',1);
        		}
        	}
        }else if(C%2==1) { //C가 홀수인 경우
        	for(int j=0; j<C;j++) {
        		if(j%2==0) {
        			append(s,'D',R-1);
        			if(j!= C-1) {
        				append(s, 'R', 1);
        			}
        		}else {
        			append(s, 'U', R-1);
        			append(s, 'R', 1);
        		}
        	}
        }
        else {	//R과 C가 둘다 짝수인 경우
        	int x, y;
        	x=0; 
        	y=1;
        	for(int i=0; i<R;  i++) {	//'검정칸' 중 젤 작은 수를 찾는다 
        		for(int j=0; j<C; j++) {
        			if((i+j)%2==1) {
        				if(map[x][y]> map[i][j]) {
        					x= i;
        					y= j;
        				}
        			}
        		}
        	}
        	int x1=0;
        	int y1=0;
        	int x2=R-1;
        	int y2=C-1;
        	StringBuilder s2 = new StringBuilder();
        	while(x2-x1>0) {//시작점과 도착점에서 인접한 2줄 검정칸이 없다면 지우기 
        		if(x1/2 <x/2) {
        			append(s,'R',C-1);
        			append(s,'D',1);
        			append(s,'L',C-1);
        			append(s,'D',1);
        			x1 +=2;
        		}
        		if(x/2 < x2/2) {
        			append(s2, 'R', C-1);
        			append(s2, 'D', 1);
        			append(s2, 'L', C-1);
        			x2 -=2;
        		}
        	}
        	while(y2-y1>1) {
        		if(y1/2 <y/2) {
        			append(s,'D',1);
        			append(s,'R',1);
        			append(s,'U',1);
        			append(s,'R',1);
        			y1+=2;
        		}
        		if(y1/2 < y2/2) {
        			append(s2,'D',1);
        			append(s2,'R',1);
        			append(s2,'U',1);
        			append(s2,'R',1);
        			y2 -=2;
        		}
        	}
        	if(y==y1) { //2X2 칸이 남았을 경우
        		append(s,'R',1);
        		append(s,'D',1);
        	}else {
        		append(s,'D',1);
        		append(s,'R',1);
        	}
        	s2.reverse();//도착점에서 출발한 경로 뒤집기
        	s.append(s2);
        }
        bw.append(s);
        bw.flush();
    }
}
