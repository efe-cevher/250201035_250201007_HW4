package main;

import java.util.ArrayList;
import java.util.List;

public class VanillaBST<K extends Comparable<K>, V> implements BST<K, V> {

	
	private Node<K,V>[] nodeArray;
	private int numOfEntries;
	
	@SuppressWarnings("unchecked")
	public VanillaBST() {
		nodeArray = (Node<K,V>[])new Object[128];
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
		
		Node<K,V> newNode =new Node<K, V>(key, value);
		int currentIndex = 0;
		boolean added = false;
        while (!added)
        {
           if (key.compareTo((nodeArray[currentIndex].getKey()) ) < 0) {
              if (nodeArray[currentIndex*2+1] == null) {
                 nodeArray[currentIndex*2+1] = newNode;
                 added = true;
              }
              else
                 currentIndex = currentIndex*2+1;
           }
           else {
              if (nodeArray[currentIndex*2+2] == null) {
                 nodeArray[currentIndex*2+2] = newNode;
                 added = true;
              }
              else
                 currentIndex = currentIndex*2+2;
           }
           
        }
        numOfEntries++;	
	}
	public void remove(K key) {
		
		int targetIndex = getNodeIndex(key);
		
		if(targetIndex != -1)
		{
			nodeArray[targetIndex] = null;
			
			if (nodeArray[targetIndex*2+1] == null)
			{
				for (int i = targetIndex; i <= nodeArray.length; i++)
				{
				    nodeArray[i+1] = nodeArray[i];
				}
			}
			Node<K,V> currentNode = nodeArray[targetIndex];
			V closestVal = currentNode.getValue();
			
			while (currentNode != null)
	        {	
				closestVal = currentNode.getValue();
				targetIndex = targetIndex*2+2;
				currentNode = nodeArray[targetIndex];
	        }
			
			
			
		}
		else
		{
			throw new e NoSuchElementException;
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
		V minVal = currentNode.getValue();
		
		while (currentNode != null)
        {	
			minVal = currentNode.getValue();
			currentIndex = currentIndex*2+1;
			currentNode = nodeArray[currentIndex];
        }

		return minVal;
	}

	
	public V max() {

		return null;
	}

	
	public V[] lessThan(K key) {

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


