package itec220.labs;

import static org.junit.Assert.fail;//remove once code is complete



import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings("unused")
public class BSTree <Key extends Comparable<Key>, Value> implements BinarySearchTree<Key, Value>  {
	
	
	private Node root;	
	private Comparator<Key> comparator;	
	private int size = 0;

	
	public BSTree() {
		this.comparator = (k1 , k2) -> {return k1.compareTo(k2);};
	}
	
	public BSTree(Comparator<Key> comparator) {
		
		super();
		this.comparator = comparator;
	}
	
	private class Node
	{
				
		public Node(Key key, Value data) {
			// this is a leaf node
			super();			
			this.data = data;
			this.key = key;
			this.rightChild = null;
			this.leftChild = null;
		}

		 public Key key;		 
		 public Value data;		
		 public Node rightChild;		
		 public Node leftChild;
	}
	
	private Value recursiveFind(Node current, Key key) {
		if(current == null) {
			return null;
		}
		
		int compare = comparator.compare(key, current.key);
		if(compare == 0) {
			return current.data;
		}
		else if(compare < 0) {
			return recursiveFind(current.leftChild, key);
		}
		else {
			return recursiveFind(current.rightChild, key);
		}
	}
	 
	public Value findRecursively(Key key) {
		return recursiveFind(root, key);
	}
	 
	private Value findIteratively(Key key) {
		Node current = root;
		
		while(current != null) {
			int compare = comparator.compare(key, current.key);
			if(compare == 0) {
				return current.data;
			}
			else if (compare < 0) {
				current = current.leftChild;
			}
			else {
				current = current.rightChild;
			}
		}
		
		return (current != null) ? current.data : null;
	}
	
	private Node findParent(Key key) {
		Node current = root;
		
		//while have child
		while(current.leftChild != null || current.rightChild != null) {
			if(current.leftChild != null) {
				if(comparator.compare(key, current.leftChild.key) == 0) {
					return current;
				}
			}
			if(current.rightChild != null) {
				if(comparator.compare(key, current.rightChild.key) == 0) {
					return current;
				}
			}
			
			if(comparator.compare(key, current.key) < 0) {
				current = current.leftChild;
			}
			else {
				current = current.rightChild;
			}
		}
		
		return null;
	}
	
	private Node findFutureParent(Key key) {
		Node current = root;
		
		while(current.leftChild != null || current.rightChild != null) {
			
			if(comparator.compare(key, current.key) < 0) {
				if(current.leftChild != null) {
					current = current.leftChild;
				}
				else {
					return current;
				}
			}
			else {
				if(current.rightChild != null) {
					current = current.rightChild;
				}
				else {
					return current;
				}
			}
		}
		
		return current;
	}
	
	private Node findNode(Key key) {
		if(key.equals(root.key)) {
			return root;
		}
		
		Node parent = findParent(key);
		
		if(parent == null) {
			return null;
		}
		
		return (parent.leftChild.key.equals(key)) ? parent.leftChild : parent.rightChild;
	}
	 
	
	
	@Override
	public boolean insert(Key key, Value value) {
		if(isEmpty()) {
			root = new Node(key, value);
		}
		else if(contains(key)) {
			return false;
		}
		else {
			Node parent = findFutureParent(key);
			
			if(comparator.compare(key, parent.key) < 0) {
				parent.leftChild = new Node(key, value);
			}
			else {
				parent.rightChild = new Node(key, value);
			}
		}
		
		size++;
		return true;
	}
	@Override
	public void printTree(Traversal order) {
		ArrayList<Value> list = values(order);
		
		list.forEach(System.out::println);
	}
	
	@Override
	public void clear() {
		size = 0;
		root = null;
	}
	

	public boolean isEmpty()
	{
		return (size == 0 && root == null);
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean contains(Key key) {
		return (find(key) != null);
	}
	
	private Node findMinimum(Node original) {
		while(original.leftChild != null) {
			original = original.leftChild;
		}
		
		return original;
	}

	private Node findSuccessor(Node original) {
		if(original.rightChild != null) {
			return findMinimum(original.rightChild);
		}
		
		Node parent = findParent(original.key);
		
		while(parent != null && original.equals(parent.rightChild)) {
			original = parent;
			parent = findParent(parent.key);
		}
		
		return parent;
	}
	
	private void replaceNode(Node original, Node child) {
		Node parent = findParent(original.key);
		
		if(parent.leftChild.key.equals(original.key)) {
			parent.leftChild = child;
		}
		else {
			parent.rightChild = child;
		}
	}
	
	public Value remove(Key key) {
		if(isEmpty()) {
			return null;
		}
		
		Node current = findNode(key);
		
		Value data = current.data;
		
		Node parent = findParent(current.key);
		
		//No children
		if(current.leftChild == null & current.rightChild == null) {
			if(root.equals(current)) {
				root = null;
			}
			else {
				
				if(parent.leftChild.equals(current)) {
					parent.leftChild = null;
				}
				else {
					parent.rightChild = null;
				}
				
				current = null;
			}
		}
		//one child
		else if(current.leftChild != null ^ current.rightChild != null) {
			if(current.leftChild != null) {
				if(parent.leftChild.key.equals(current.key)) {
					parent.leftChild = current.leftChild;
				}
				else {
					parent.rightChild = current.leftChild;
				}
			}
			else {
				if(parent.leftChild.key.equals(current.key)) {
					parent.leftChild = current.rightChild;
				}
				else {
					parent.rightChild = current.rightChild;
				}
			}
		}
		//two children
		else {
			Node successor = findSuccessor(current);
			Node successorParent = findParent(successor.key);
			
			if(!successorParent.equals(current)) {
				replaceNode(successor, successor.rightChild);
				
				successor.rightChild = current.rightChild;
			}
			if(parent == null) {
				root = successor;
			}
			else if(parent.leftChild.key.equals(current.key)) {
				parent.leftChild = successor;
			}
			else {
				parent.rightChild = successor;
			}
			
			successor.leftChild = current.leftChild;
		}
		
		size--;
		return data;
	}
	
    private void inOrder(Node current, ArrayList<Value> list) {
        if(current != null) {
            inOrder(current.leftChild, list);
            list.add(current.data);
            inOrder(current.rightChild, list);
        }
    }
    
    private void postOrder(Node current, ArrayList<Value> list) {
        if(current != null) {
            postOrder(current.leftChild, list);
            postOrder(current.rightChild, list);
            list.add(current.data);
        }
    }
    
    private void preOrder(Node current, ArrayList<Value> list) {
        if(current != null) {
            list.add(current.data);
            preOrder(current.leftChild, list);
            preOrder(current.rightChild, list);
        }
    }
    
	private void levelOrder(Node root, ArrayList<Value> list) {
		QueueList<Node> queue = new QueueList<>();
		queue.enqueue(root);
		
		while(!queue.isEmpty()) {
			Node current = queue.dequeue();
			
			if(current != null) {
				list.add(current.data);

				queue.enqueue(current.leftChild);
				queue.enqueue(current.rightChild);
			}
		}
	}
    
    @Override
    public ArrayList<Value> values(Traversal order) {
        ArrayList<Value> list = new ArrayList<>();
        
        switch(order) {
        case IN_ORDER:
            inOrder(root, list);
            break;
        case POST_ORDER:
            postOrder(root, list);
            break;
        case PRE_ORDER:
            preOrder(root, list);
            break;
        case LEVEL_ORDER:
        	levelOrder(root, list);
        default:
            break;
        }
        
        return list;
    }

	@Override
	public Value find(Key key) {
		return findRecursively(key);
	}	
	

}
