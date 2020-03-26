//Baekjoon - 11576

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
public class BaekJoon11576 {

	
	public static void main(String[] args)throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strToken= br.readLine().split(" ");
		int A= Integer.parseInt(strToken[0]);
		int B= Integer.parseInt(strToken[1]);
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int m = Integer.parseInt(br.readLine());
		int sum = 0;
		strToken = br.readLine().split(" ");
		//10 진법으로 변환 Pow 함수를 쓰지 않는 방법
		for(int i=0; i<m; i++) {
			sum = sum*A + Integer.parseInt(strToken[i]);
		}
		
		//B진법으로 변환
		while(sum !=0) {
			stack.push(sum%B);
			sum /= B;
		}
		
		//Stack을 사용하는 이유는, StringBuilder를 쓰면 2자리 수의 경우 reverse를 해주면 
		//앞뒤가 바껴버리기 때문에 문제가 발생할 수 있기 때문이다
		int size = stack.size();
		for(int i=0; i<size; i++) {
			if(i== size-1)
				System.out.print(stack.pop());
			else
				System.out.print(stack.pop()+" ");
		}
	}	
}