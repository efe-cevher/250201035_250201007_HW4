package main;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List<String> keyList = new ArrayList<String>();
		List<Integer> valueList = new ArrayList<Integer>();
		
		keyList.add("a");
		keyList.add("b");
		keyList.add("c");
		keyList.add("d");
		keyList.add("e");
		keyList.add("f");
		keyList.add("g");
		keyList.add("h");
		
		
		valueList.add(1);
		valueList.add(2);
		valueList.add(3);
		valueList.add(4);
		valueList.add(5);
		valueList.add(6);
		valueList.add(7);
		valueList.add(8);

	
		
		BST<String,Integer> StockList = new VanillaBST<String,Integer>(keyList,valueList);
		
		List<Integer> arr = StockList.greaterThan("e");
		
		for(Integer element:arr)
		{
			System.out.println(element);
		}
		
	
		
		StockList.display();
		


		

	}

}
