//Baekjoon - 10825_@

import java.io.*;
import java.util.Arrays;


public class BaekJoon10825_2 {

	public static void main(String[] args)throws Exception{
		class Student implements Comparable<Student>{
			String name;
			int kor, eng, math;
			Student(String name, int kor, int eng, int math){
				this.name = name;
				this.kor = kor;
				this.eng = eng;
				this.math = math;
			}
			
			@Override
			public int compareTo(Student o) {
				if(this.kor > o.kor) {
					return -1;
				}else if (this.kor == o.kor) {
					if(this.eng < o.eng) {
						return -1;
					}else if (this.eng == o.eng) {
						if(this.math > o.math) {
							return -1;
						}else if(this.math==o.math) {
							return this.name.compareTo(o.name);
						}else {
							return 1;
						}
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
		Student[] sArr = new Student[n];

		for(int i=0; i<n; i++) {
			String[] s = br.readLine().split(" ");
			sArr[i]= new Student(s[0], Integer.parseInt(s[1]),
					Integer.parseInt(s[2]),Integer.parseInt(s[3]));			
		}
		Arrays.sort(sArr);
		for(Student s : sArr) {
			System.out.println(s.name);
		}
	}	
}