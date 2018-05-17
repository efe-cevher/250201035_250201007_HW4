package main;

public class App {

	public static void main(String[] args) {
		
		BST<Integer,String> Bst = new VanillaBST<Integer,String>();
		Bst.add(10, "a");
		Bst.add(5, "b");
		Bst.add(15, "o​");
		Bst.add(3, "orta​");
		Bst.add(4, "orta​");
		Bst.add(2, "orta​");
		Bst.display();
	}

}
