package main;


public class VanillaBST<K extends Comparable<K>, V> implements BST<K, V> {

	private Node<K,V>[] nodeArray;
	private int numOfEntries;
	
	@SuppressWarnings("unchecked")
	public VanillaBST() {
		nodeArray = (Node<K,V>[])new Object[128];
	}
	
	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(K key,V value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(K key, V value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public K[] keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V[] values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V min() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V max() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V[] lessThan(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V[] greaterThan(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isFullTree() {
		// TODO Auto-generated method stub
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
		
		
	}
	
	
	
}


