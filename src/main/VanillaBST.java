package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class VanillaBST<K extends Comparable<K>, V> implements BST<K, V> {

	
	private Node<K,V>[] nodeArray;
	private int size;
	private int maxIndex;
	
	@SuppressWarnings("unchecked")
	public VanillaBST() {
		nodeArray = (Node<K,V>[])new Node[1];
		maxIndex = 1;
	}
	@SuppressWarnings("unchecked")
	public VanillaBST(List<K> keyList, List<V> valueList) {
		if(keyList.size() == valueList.size()) 
		{
			Node<K,V>[] tmpArray = (Node<K,V>[])new Node[keyList.size()];
			nodeArray = (Node<K,V>[])new Node[keyList.size()];
			for(int i=0; i<keyList.size();i++)
			{
				K key = keyList.get(i);
				V value = valueList.get(i);
				Node<K,V> newNode = new Node<K, V>(key, value);
				tmpArray[i] = newNode;
				
			}
			insertionSort(tmpArray);
			balance(tmpArray);
			
		}
	}
	private void balance(Node<K,V>[] arr) {
		int n = arr.length;
		int mid = n/2;

		
		add(arr[mid].getKey(),arr[mid].getValue());
		
		Node<K,V>[] left = Arrays.copyOfRange(arr, 0, mid);
		Node<K,V>[] right = Arrays.copyOfRange(arr, mid+1, n);

		balance(left);
		balance(right);
	}
	
	
	
	private void insertionSort(Node<K,V>[] arr)
	{
	   int i, j;
	   Node<K,V> node;
	   
	   for (i = 1; i < arr.length; i++)
	   {
	       node = arr[i];
	       j = i-1;

	       while (j >= 0 && arr[j].getKey().compareTo(node.getKey()) > 0)
	       {
	           arr[j+1] = arr[j];
	           j = j-1;
	       }
	       arr[j+1] = node;
	   }
	}
	
		
	

	private int getNodeIndex(K key) {
		int currentIndex = 0;
		boolean found = false;
		while (!found)
        {	
			if(nodeArray[currentIndex] != null)
			{
			
				if (key.compareTo((nodeArray[currentIndex].getKey()) ) == 0)
				{
					found = true;
				}
				else if (key.compareTo((nodeArray[currentIndex].getKey()) ) < 0) 
	            {
	                 currentIndex = currentIndex*2+1;
	            }
	            else 
	            {
	                 currentIndex = currentIndex*2+2;
	            }
			
			}
			else {
				currentIndex = -1;
				break;
			}
			
        }
		return currentIndex;
	}
	public V get(K key) {
		int targetIndex = getNodeIndex(key);
		return nodeArray[targetIndex].getValue();
	}
	

	public void add(K key,V value) {
		
		if (nodeArray.length < maxIndex*2+3)
		{
			nodeArray = Arrays.copyOf(nodeArray,maxIndex*2+3);
		}
		
		
		Node<K,V> newNode = new Node<K, V>(key, value);
		int currentIndex = 0;
		boolean added = false;
        while (!added)
        {if (maxIndex == 1){
        	nodeArray[currentIndex] = newNode;
        	added = true;
        	maxIndex += 1; 
        }
        	else if (key.compareTo((nodeArray[currentIndex].getKey()) ) < 0) {
              if (nodeArray[currentIndex*2+1] == null) {
                 nodeArray[currentIndex*2+1] = newNode;
                 added = true;
                 if (currentIndex*2+1 > maxIndex)
                     maxIndex = currentIndex*2+1;
              }
              else
                 currentIndex = currentIndex*2+1;
           }
           else {
              if (nodeArray[currentIndex*2+2] == null) {
                 nodeArray[currentIndex*2+2] = newNode;
                 added = true;
                 if (currentIndex*2+2 > maxIndex)
                     maxIndex = currentIndex*2+2;
              }
              else
                 currentIndex = currentIndex*2+2;
           }
           
        }
        size++;	
	}
	
	public void remove(K key) {
		
		int targetIndex = getNodeIndex(key);
		
		if (targetIndex != -1)
		{
			SearchRemove(key,targetIndex);
		}
		else
		{
			throw new NoSuchElementException("There is no element with given key");
		}
		
	}
	
	
	private void remove(int targetIndex) {
 
	
		// if its a leaf
		if (isLeaf(targetIndex))
		{
			nodeArray[targetIndex] = null;
			size--;
		}

		// if node only has left child
		else if ((nodeArray[targetIndex*2+1] != null) && (nodeArray[targetIndex*2+2] == null)) 
		{
	       nodeArray[targetIndex] = nodeArray[targetIndex*2+1];
		}
		// if node only has right child
		else if ((nodeArray[targetIndex*2+1] == null) && (nodeArray[targetIndex*2+2] != null)) 
		{
			targetIndex = 2*targetIndex+2;
			size--;
		}
		// if node has two children
		else
		{
			int index = SearchInorderSuccessor(targetIndex*2+2);
			nodeArray[targetIndex] = nodeArray[index];
			
			if (nodeArray[index*2+2] != null)
			{
				nodeArray[index] = nodeArray[index*2+2];
				nodeArray[index*2+2] = null;
			}
			
			if (isLeaf(index))
			{
				nodeArray[index] = null;
			}
			
			size--;
			
		}				
	}
		
	private boolean SearchRemove(K key, int targetIndex){
		
		if(nodeArray[targetIndex] != null && targetIndex <= maxIndex)
		{
			if(key.compareTo((nodeArray[targetIndex].getKey()) ) == 0)
			{
				remove(targetIndex);
				return true;
			}
			else if(key.compareTo((nodeArray[targetIndex].getKey()) ) < 0)
			{
				targetIndex = targetIndex*2 + 1;
				SearchRemove(key, targetIndex);
			}
			else
			{
				targetIndex = targetIndex*2 + 2;
				SearchRemove(key, targetIndex);
			}
		}
		
		return false;
	}
	
	
	private int SearchInorderSuccessor(int targetIndex)
	{
		if (nodeArray[targetIndex*2+1] != null)
		{
			targetIndex = targetIndex*2+1;
			
			if (isLeaf(targetIndex*2+1))
			{
				return targetIndex;
			}
			
			return SearchInorderSuccessor(targetIndex);
		}
		else
		{
			return targetIndex;
		}
		
	}

	private boolean isLeaf(int targetIndex) 
	{
		if ((targetIndex*2+1 >= nodeArray.length) || (targetIndex*2+2 >= nodeArray.length))
		{
			return true;
		
		}
		else if ((nodeArray[targetIndex*2+1] == null) && (nodeArray[targetIndex*2+2] == null))
		{    
			return true;
		}
		else
		{
			return false;
		}
	}

	public void update(K key, V value) {
		int targetIndex = getNodeIndex(key);
		Node<K, V> newNode = nodeArray[targetIndex];
		newNode.setValue(value);
		
	}

	
	public List<K> keys() {
		
		List<K> keyList = new ArrayList<K>();
		
		for(int i = 0; i < nodeArray.length; i++) 
		{
			if (nodeArray[i] != null)
			{
				keyList.add(nodeArray[i].getKey());
			}
		}
			
		return keyList;
	}

	
	public List<V> values() {

		List<V> valueList = new ArrayList<V>();
		
		for(int i = 0; i < nodeArray.length; i++) 
		{
			if (nodeArray[i] != null)
			{
				valueList.add(nodeArray[i].getValue());
			}	
		}
		
		return valueList;	
	}
	

	
	public V min() {
		int currentIndex = 0;
		Node<K,V> currentNode = nodeArray[currentIndex];
		V value = currentNode.getValue();
		
		while (currentNode != null)
        {	
			value = currentNode.getValue();
			currentIndex = currentIndex*2+1;
			currentNode = nodeArray[currentIndex];
        }

		return value;
	}

	
	public V max() {
		
		int currentIndex = 0;
		Node<K,V> currentNode = nodeArray[currentIndex];
		V value = currentNode.getValue();
		
		while (currentNode != null)
        {
			value = currentNode.getValue();
			currentIndex = currentIndex*2+2;
			currentNode = nodeArray[currentIndex];
        }

		return value;
	}

	
	public List<V> lessThan(K key) {
		ArrayList<V> less = new ArrayList<V>();
		int currentIndex, targetIndex = getNodeIndex(key);
		for(currentIndex = 0; currentIndex < maxIndex ; currentIndex++) {
			if ((nodeArray[currentIndex].getKey().compareTo(nodeArray[targetIndex].getKey()))==-1) {
				less.add(nodeArray[currentIndex].getValue());
			}
			
		}
		return less;
	}

	
	public List<V> greaterThan(K key) {
		ArrayList<V> greater = new ArrayList<V>();
		int currentIndex, targetIndex = getNodeIndex(key);
		for(currentIndex = 0; currentIndex < maxIndex ; currentIndex++) {
			if ((nodeArray[currentIndex].getKey().compareTo(nodeArray[targetIndex].getKey()))==1) {
				greater.add(nodeArray[currentIndex].getValue());
			}
			
		}
		return greater;
	}

	
	public int size() {

		return size;
	}

	
	public int height() {
		int height;
		if (size==1) {
			height = 1;
		}
		else {
			height = (int)(Math.log(maxIndex + 1) / Math.log(2)) + 1;
		}

		return height;
	}

	public void display() {
		System.out.println("Root: " + nodeArray[0].display());
		
		display(0,0);
		
	}
	private void display(int currentIndex, int k) {
		
		if (!isLeaf(currentIndex)) {
			
			if (nodeArray[currentIndex*2+1] != null) {
				
				
				for (int i=0;i<k;i++) {
					System.out.print(" ");
				}
				if(k>0)
					System.out.print("┗━");
				else
					System.out.print("┗━━");
					
				System.out.println("Left: " + nodeArray[currentIndex*2+1].display());
				
			}
			else {
				
				for (int i=0;i<k;i++) {
					System.out.print(" ");
				}
				if(k>0)
					System.out.print("┗━");
				else
					System.out.print("┗━━");
				System.out.println("Left: -");
			}
			
			display(currentIndex*2+1,k+3);
			if (nodeArray[currentIndex*2+2] != null) {
				
				
				for (int i=0;i<k;i++) {
					System.out.print(" ");
				}
				if(k>0)
					System.out.print("┗━");
				else
					System.out.print("┗━━");
				System.out.println("Right: " + nodeArray[currentIndex*2+2].display());
				
			}
			else {
				
				for (int i=0;i<k;i++) {
					System.out.print(" ");
				}
				if(k>0)
					System.out.print("┗━");
				else
					System.out.print("┗━━");
				System.out.println("Right: -");
			}currentIndex = currentIndex*2+2;
			display(currentIndex,k+3);
		}
		
	}

	
	public boolean isFullTree() {
		boolean isFull = false;
		int total = 0;
		for (int i = 0 ; i < height() ; i++ ) {
			total += Math.pow(2, i);
		}
		if (total == size()) {
			isFull = true;
		}
		
		return isFull;
	}

	private class Node<K,V> {
		
		private V value;
		private K key;
		
		public Node(K key, V value) 
		{
			this.key = key;
			this.value = value;	
		}
		public K getKey() {
			return key;
		}
		public void setKey(K desiredKey) {
			this.key = desiredKey;
		}
		public V getValue() {
			return value;
		}
		public void setValue(V desiredValue) {
			this.value = desiredValue;
		}
		public String display() {
			String str = "(" + key + ", " + value + ")";
			return str;
			
		}
		                  
	}
}


