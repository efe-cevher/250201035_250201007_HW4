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
		System.out.println(nodeArray.length);
		maxIndex = 1;

	}

	private int getNodeIndex(K key) {
		int currentIndex = 0;
		boolean found = false;
		while (!found)
        {	
			if (key.compareTo((nodeArray[currentIndex].getKey()) ) == 0){
				found = true;
			}
			else if (key.compareTo((nodeArray[currentIndex].getKey()) ) < 0) 
           {
                 currentIndex = currentIndex*2+1;
           }
           else {
                 currentIndex = currentIndex*2+2;
           }
        }
		if (found)
		{
			return currentIndex;
		}
		else
		{
			return -1;
		}
		
	}
	public V get(K key) {
		
		return null;
	}
	

	public void add(K key,V value) {
		
		if (nodeArray.length < maxIndex*2+3)
		{
			Arrays.copyOf(nodeArray,maxIndex*2+3);
		}
		
		
		Node<K,V> newNode = new Node<K, V>(key, value);
		int currentIndex = 0;
		boolean added = false;
        while (!added)
        {
           if (key.compareTo((nodeArray[currentIndex].getKey()) ) < 0) {
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
			int index = SearchInorderSuccessor(targetIndex);
			nodeArray[targetIndex] = nodeArray[index];
			
			if (nodeArray[index*2+2] != null)
			{
				nodeArray[index] = nodeArray[index*2+2];
				nodeArray[index*2+2] = null;
			}
			
			if (!isLeaf(index))
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

	
	public V[] lessThan(K key) {
		int currentIndex = 0;
		int targetIndex = getNodeIndex(key);
		
				
				
		
		return null;
	}

	
	public V[] greaterThan(K key) {

		return null;
	}

	
	public int size() {

		return 0;
	}

	
	public int height() {

		return 0;
	}

	
	public void display() {
		
		
	}

	
	public boolean isFullTree() {

		
		return false;
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
		
	}
	
	
	
}


