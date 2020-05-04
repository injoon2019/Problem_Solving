//Programmers - 64061 (2019 īī�� ������ �ܿ� ���Ͻ� - Ʃ��)
import java.io.*;
import java.util.*;

public class Programmers64065 {
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] answer = {};
		
		s = s.substring(1, s.length()-1);	//1�� �ε������� s.length()-1 �ε��� ������
		s = s.replaceAll("\\}\\,\\{", "#");	//},{�� #���� ��ü�Ѵ�
		s = s.substring(1, s.length()-1);	//�����ִ� �յ��� ������ ��ȣ�� �����Ѵ�
		
		String[] arrS = s.split("#");
		
		//���� ���ڿ� ũ�Ⱑ ���� ���� �ͺ��� ������� LinkedHashSet�� �־��ش�
		//���ڿ� ũ�Ⱑ ���� ���� ����� ����Ѵ�
		Map<Integer, Object> map = new TreeMap<>();
		for(int i=0;  i<arrS.length; i++) {
			String[] tuple = arrS[i].split(",");
			map.put(tuple.length, tuple);
		}
		
		Iterator mapItr = map.keySet().iterator();
		
		Set<Integer> set = new LinkedHashSet<>();
		
		while(mapItr.hasNext()) {
			int key = (int)mapItr.next();
			String[] arr = (String[])map.get(key);
			
			for(String tuple: arr) {
				set.add(Integer.valueOf(tuple));
			}
		}
		
		answer = new int[set.size()];

		Iterator setItr = set.iterator();
		int index = 0;
		
		while(setItr.hasNext()) {
			answer[index] = (int)setItr.next();
			index++;
		}
		
		
		System.out.println(s);
	}	
}