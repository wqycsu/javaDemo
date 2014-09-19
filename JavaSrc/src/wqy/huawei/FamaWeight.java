package wqy.huawei;

import java.util.HashSet;
import java.util.Scanner;

public class FamaWeight {
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int n;
//		n = in.nextInt();
//		int[] weight = new int[n];
//		int[] num = new int[n];
//		for(int i=0;i<n;i++){
//			weight[i] = in.nextInt();
//		}
//		for(int i=0;i<n;i++){
//			num[i] = in.nextInt();
//		}
//		int size = getSize(n,weight,num);
//		System.out.println(size);
//		in.close();
		String str1 = "abc";
		String str2 = "dsfsfsdfabcd";
		System.out.println(str2.contains(str1));
	}
	
	public static int getSize(int n,int[] weight,int[] num){
		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<Integer> tempSet = new HashSet<Integer>();
		set.add(0);
		for(int i=0;i<n;i++){
			for(Integer m:set)
				for(int j=1;j<=num[i];j++){
					tempSet.add(m+weight[i]*j);
				}
			set.addAll(tempSet);
			tempSet.clear();
		}
		return set.size();
	}
}
