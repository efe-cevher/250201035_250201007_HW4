package main;

public class App {

	public static void main(String[] args) {
		
		BST<Integer,String> Bst = new VanillaBST<Integer,String>();
		
		Bst.add(10, "10");
		Bst.add(5, "5");
		Bst.add(15, "15");
		Bst.add(3, "3");
		Bst.add(7, "7");
		Bst.add(12, "12");
		Bst.add(17, "17");
		
		System.out.println(Bst.lessThan(17).size());
	}

}
