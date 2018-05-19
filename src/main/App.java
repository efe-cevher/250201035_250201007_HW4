package main;

public class App {

	public static void main(String[] args) {
		
		BST<String,Integer> StockList = new VanillaBST<String,Integer>();
		
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
