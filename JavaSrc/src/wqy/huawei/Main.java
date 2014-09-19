package wqy.huawei;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		int count = countCharNum(str);
		System.out.println(count);
		in.close();
	}
	
	public static int countCharNum(String str){
		if(str==null)
			return 0;
		char[] array = str.toCharArray();
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		int c = 0;
		for(int i=0;i<array.length;i++){
			if(array[i]>=0&&array[i]<=127){
				map.put(array[i], c++);
			}
		}
		return map.size();
	}

}
