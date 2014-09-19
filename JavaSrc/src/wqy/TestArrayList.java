package wqy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class MyHashMap<String,V> extends HashMap implements Comparable<MyHashMap>{

	@Override
	public int compareTo(MyHashMap o) {
		// TODO Auto-generated method stub
		return (this.keySet().toArray()[0].toString().compareTo((java.lang.String)(o.keySet().toArray()[0])));
	}
	
}
public class TestArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		MyHashMap<String,String> map = new MyHashMap<String,String>();
		MyHashMap<String,String> map1 = new MyHashMap<String,String>();
		ArrayList<MyHashMap<String,String>> list1 = new ArrayList<MyHashMap<String,String>>();
		map.put("kex", "map");
		map1.put("key", "value");
		list1.add(map);
		list1.add(map1);
		Collections.sort(list1);
		for(int i=0;i<list1.size();i++)
			System.out.println(list1.get(i));
		System.out.println(map.keySet().equals(map1.keySet()));
		list.add("1");
		list.add("2");
		for(int j=0;j<list.size();j++){
			if(list.size()>j&&list.get(j)!=null)
			{
				list.remove(j);
				list.add(j,(j+1)*10+(j+1)+"");
			}
		}
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
	}

}
