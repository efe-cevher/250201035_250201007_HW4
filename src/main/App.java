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
		
		valueList.add(1);
		valueList.add(1);
		valueList.add(1);
		valueList.add(1);
		valueList.add(1);
		

		
		
		
		
		
		
		BST<String,Integer> StockList = new VanillaBST<String,Integer>(keyList,valueList);
		
		
		
		
		StockList.add("tea", 17);
		StockList.add("towel", 24);
		StockList.add("juice", 5);
		StockList.add("glass", 36);
		StockList.add("coffee", 21);
		StockList.add("tomato", 3);
		
		StockList.display();
		
		StockList.remove("tea");
		
		System.out.println();
		
		StockList.display();
		
		

	}

}
