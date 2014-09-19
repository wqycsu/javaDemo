package wqy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class TestSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new LinkedHashSet<String>();
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		set.addAll(list);
		list.clear();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			list.add(it.next());
		}
		for(String str:list)
		{
			System.out.println(str);
		}
	}

}
