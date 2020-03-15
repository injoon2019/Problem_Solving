//Baekjoon - 10814

import java.io.*;
import java.util.Arrays;
public class BaekJoon10814 {
	
	public static void main(String[] args)throws Exception{
		class Person implements Comparable<Person>{
			int age, order;
			String name;
			Person(int age, String name, int order){
				this.age = age;
				this.name = name;
				this.order = order;
			}
			@Override
			public int compareTo(Person o) {
				if(this.age < o.age) {
					return -1;
				}else if(this.age == o.age){
					if(this.order < o.order) {
						return -1;
					}else if(this.order == o.order) {
						return 0;
					}else {
						return 1;
					}
				}else {
					return 1;
				}
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		String[] strToken;
		Person[] pArr = new Person[n];
		int age;
		String name;
		for(int i=0; i<n; i++) {
			strToken= br.readLine().split(" ");
			age = Integer.parseInt(strToken[0]);
			
			pArr[i]= new Person(age,strToken[1],i);
		}
		Arrays.sort(pArr);
		for(Person p: pArr) {
			System.out.printf("%d %s\n", p.age, p.name);
		}
	}	
}