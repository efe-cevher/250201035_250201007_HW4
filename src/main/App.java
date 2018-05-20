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
		valueList.add(1);
		valueList.add(1);
		valueList.add(1);
		valueList.add(1);
		valueList.add(1);
		valueList.add(1);
		valueList.add(1);
		valueList.add(1);
	
		
		BST<String,Integer> StockList = new VanillaBST<String,Integer>(keyList,valueList);
		
		
		
		
	
		
		StockList.display();
		


		

	}

}
