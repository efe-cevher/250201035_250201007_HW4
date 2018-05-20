package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		
		
		
		List<String> keyList = new ArrayList<String>();
		List<Integer> valueList = new ArrayList<Integer>();
		keyList.add("tea");
		valueList.add(17);
		keyList.add("towel");
		valueList.add(24);
		keyList.add("juice");
		valueList.add(5);
		keyList.add("glass");
		valueList.add(36);
		BST<String,Integer> stocklist = new VanillaBST<String,Integer>(keyList,valueList);
		String key = "a";
		Integer value;
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter base stocklist.");
		System.out.println("When you are done use quit command to quit.");
		while (true) {
			
			System.out.println("Enter the command.");
	        String command = in.nextLine();
	        
			if (command.equals("add")) {
		        System.out.println("Enter name of the product ");
		        key = in.nextLine();
		        System.out.println("Enter price of the product ");
		        value = Integer.parseInt(in.nextLine());
		        stocklist.add(key, value);
			}
	        if (command.equals("remove")) {
	        	System.out.println("Enter name of the product ");
	 	        key = in.nextLine();
	 	        stocklist.remove(key);
	        }
	        if (command.equals("update")) {
	        	System.out.println("Enter name of the product ");
		        key = in.nextLine();
		        System.out.println("Enter price of the product ");
		        value = Integer.parseInt(in.nextLine());
		        stocklist.update(key, value);
	        }
	        if (command.equals("min")) {
	        	System.out.println(stocklist.min());
		        
	        }
	        if (command.equals("max")) {
	        	System.out.println(stocklist.max());
		        
	        }
	        if (command.equals("lessthan")) {
	        	System.out.println("Enter name of the product ");
	 	        key = in.nextLine();
	        	System.out.println(stocklist.lessThan(key));
		        
	        }if (command.equals("greaterthan")) {
	        	System.out.println("Enter name of the product ");
	 	        key = in.nextLine();
	        	System.out.println(stocklist.greaterThan(key));
		        
	        }
	        if (command.equals("get")) {
	        	System.out.println("Enter name of the product ");
	 	        key = in.nextLine();
	        	System.out.println(stocklist.get(key));
		        
	        }
	        if (command.equals("keys")) {
	        	System.out.println(stocklist.keys());
		        
	        }
	        if (command.equals("values")) {
	        	System.out.println(stocklist.values());
		        
	        }
	        if (command.equals("help")) {
	        	System.out.println("Commands");
	        	System.out.println("get");
	        	System.out.println("values");
	        	System.out.println("keys");
	        	System.out.println("greaterthan");
	        	System.out.println("lessthan");
	        	System.out.println("max");
	        	System.out.println("min");
	        	System.out.println("update");
	        	System.out.println("add");
	        	System.out.println("remove");
	        	System.out.println("quit");
	        }
	        if (command.equals("quit")) {
	        	break;
	        }
		}
		in.close();
		
		BST<String,Integer> stocklist = new VanillaBST<String,Integer>(keyList,valueList);
		
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

