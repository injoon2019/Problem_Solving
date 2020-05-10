//Kakao Summer Internship 2020 _3
import java.io.*;
import java.util.*;
public class Kakao_SummerInternship2020_3 {
	static int[] numGems;
	static boolean[] visited;
	static int minStart = Integer.MAX_VALUE;
	static int minLast =  Integer.MAX_VALUE;
	static int minLength = Integer.MAX_VALUE;
	static HashMap<String, Integer> map;
	static HashMap<String, Integer> newMap;
	public static void main(String[] args)throws Exception{
		//String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		String[] gems = {"AA", "AB", "AC", "AA", "AC"};
		
		numGems = new int[gems.length];
		
		int[] ans = solution(gems);
		System.out.println(ans[0]+" "+ans[1]);
	}
	
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        map = new HashMap<>();
        newMap = new HashMap<>();
        
        
        int index = 0;
        for(int i=0;i<gems.length; i++) {
        	if(map.containsKey(gems[i])) {
        		numGems[i] = map.get(gems[i]);
        	}else {
        		map.put(gems[i], index);
        		numGems[i] = index++;
        	}
        }
        
        
        
        for(int i=0; i<gems.length; i++) {
        	copyHash();
        	dfs(gems, i,i);
        }
        answer[0] = minStart+1;
        answer[1] = minLast+1;
        return answer;
    }

    public static void dfs(String[] gems, int start, int last) {
    	if(last == gems.length) {
    		return;
    	}
    	
    	//visited[map.get(gems[last])] =true;
    	newMap.remove(gems[last]);
    	
    	if(newMap.isEmpty()) {
    		if(last-start+1 < minLength) {
    			minLength = last-start +1;
    			minStart = start;
    			minLast = last;
    	
    		}else if(minLength == last-start+1) {
    			if(minStart > start) {
    				minStart = start;
    				minLast = last;
    			}
    		}
    	}else{
    		dfs(gems, start, last+1);
    	}
    }
    
    public static HashMap<String, Integer> copyHash(){
    	newMap = new HashMap<>();
    	for (String key : map.keySet()) {
    	    newMap.put(key, map.get(key));
    	}
    	return newMap;
    }
    
    public static boolean check() {
    	for(int i=0; i<visited.length; i++) {
    		if(visited[i]==false)
    			return false;
    	}
    	return true;
    }
}
