package wqy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TestString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "P-string";
		String str1 = str.toLowerCase();
		String str2 = "P-string string";
		System.out.println(str2.contains(str1));
		String str3 = "123/456/789/10.pdf";
		ArrayList<String> list = new ArrayList<String>();
		list.add("123/456/789.pdf");
		list.add("123/56.pdf");
		list.add("123/12.pdf");
		list.add("123/456/789.pdf");
		list.add("123/56.pdf");
		list.add("123/ab.pdf");
		Collections.sort(list);
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
		String str4 = str3.substring(0,str3.lastIndexOf('/'));
		System.out.println(str4);
	}

}
