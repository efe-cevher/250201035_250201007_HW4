package main;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
//		List<String> keyList = new ArrayList<String>();
//		List<Integer> valueList = new ArrayList<Integer>();
//		
//		keyList.add("a");
//		keyList.add("b");
//		keyList.add("c");
//		keyList.add("d");
//		keyList.add("e");
//		keyList.add("f");
//		keyList.add("g");
//		keyList.add("h");
//		keyList.add("i");
//		keyList.add("j");
//		keyList.add("k");
//		keyList.add("l");
//		keyList.add("m");
//		
//		
//		valueList.add(1);
//		valueList.add(2);
//		valueList.add(3);
//		valueList.add(4);
//		valueList.add(5);
//		valueList.add(6);
//		valueList.add(7);
//		valueList.add(8);
//		valueList.add(9);
//		valueList.add(10);
//		valueList.add(11);
//		valueList.add(12);
//		valueList.add(13);
		
		BST<String,Integer> stocklist = new VanillaBST<String,Integer>();
		
		
	}
		
	public void addStock(BST<String,Integer>stocklist, String key, Integer value)
	{
		
		if (stocklist.get(key) == null && isLowerCased(key))
		{
			stocklist.add(key, value);
		}
	}


	private boolean isLowerCased(String str)
	{
		boolean result = true;
		for (int i=0; i<str.length();i++) {
			char ch = str.charAt(i);
		
			if (Character.isUpperCase(ch))
			{
				result = false;
			}
		}
			return result;
		
		
		
		

	}

}
