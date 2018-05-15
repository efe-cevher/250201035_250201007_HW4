package main;


public class VanillaBST<K extends Comparable<K>, V> implements BST<K, V> {

	
	private Node<K,V>[] nodeArray;
	private int numOfEntries;
	
	@SuppressWarnings("unchecked")
	public VanillaBST() {
		nodeArray = (Node<K,V>[])new Object[128];
	}

	
	public V get(K key) {
		
		return null;
	}


	public void add(K key,V value) {
		
		
	}


	public void update(K key, V value) {

		
	}

	
	public K[] keys() {

		return null;
	}

	
	public V[] values() {

		return null;
	}

	
	public V min() {
		
		return null;
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


