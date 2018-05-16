package main;

import java.util.List;

public class VanillaBST<K extends Comparable<K>, V> implements BST<K, V> {

	private Node<K,V>[] nodeArray;
	private int size;
	
	@SuppressWarnings("unchecked")
	public VanillaBST() {
		nodeArray = (Node<K,V>[])new Object[128];
	}
	
	@Override
	public V get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(K key, V value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<V> values() {
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
	public List<V> lessThan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<V> greaterThan() {
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
		public K getKey() {
			
			return key;
		}
		
		public V getValue() {
			
			return value;
		}
		public V setValue(V value) {
			
			this.value = value;
		}
	}
	
	
	
}


