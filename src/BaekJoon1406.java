//Baekjoon - 1406

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class BaekJoon1406 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
		String[] strToken;
		LinkedList<Character> linkedlist = new LinkedList<>();
		int index = str.length();
		for(int i=0; i<str.length(); i++) {
			linkedlist.add(str.charAt(i));
		}
		String cmd;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			strToken = br.readLine().split(" ");
			cmd = strToken[0];
			switch(cmd) {
				case "L":{
					if(index>0)
						index--;
						break;
				}
				case "D":{
					if(index<linkedlist.size())
						index++;
					break;
				}
				case "B":{
					if(index>0)
						linkedlist.remove(--index);
					break;
				}
				case "P":{
					linkedlist.add(index, strToken[1].charAt(0));
					index++;
					break;
				}		
			}
		}
		int size= linkedlist.size();
		for(int i=0; i<size;  i++) {
			sb.append(linkedlist.poll());
		}
		bw.append(sb);
		bw.flush();
	}
}