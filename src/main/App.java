package main;

public class App {

	public static void main(String[] args) {
		
		BST<Integer,String> Bst = new VanillaBST<Integer,String>();
		
		Bst.add(10, "10");
		Bst.add(5, "5");
		Bst.add(15, "15");
		Bst.add(3, "3");
		Bst.add(2, "2");
		Bst.add(7, "7");
		Bst.add(6, "6");
		Bst.add(4, "4");
		
		Bst.add(8, "8");
		Bst.add(12, "12");
		Bst.add(17, "17");
		Bst.add(16, "16");
		Bst.add(18, "18");
		System.out.println(Bst.height());
		Bst.display();
		System.out.println(Bst.keys());
		System.out.println(Bst.greaterThan(3));
		System.out.println(Bst.lessThan(3));
	}

}
