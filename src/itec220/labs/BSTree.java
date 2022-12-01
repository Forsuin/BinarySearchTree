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
	
	private Node findNode(Key key) {
		Node current = root;
		
		while(current != null) {
			int compare = comparator.compare(key, current.key);
			if(compare == 0) {
				return current;
			}
			else if (compare < 0) {
				current = current.leftChild;
			}
			else {
				current = current.rightChild;
			}
		}
		
		return (current != null) ? current : null;
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
		Node parent = findParent(key);
		
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
	
	private void shiftNodes(Node original, Node replacement) {
		Node origParent = findParent(original.key);
		
		//replace root
		if(origParent == null) {
			root = replacement;
		}
		else if(origParent.key.equals(original.key)) {
			origParent.leftChild = replacement;
		}
		else {
			origParent.rightChild = replacement;
		}
	}
	
	public Value remove(Key key) {
<<<<<<< HEAD
		if(isEmpty() || !contains(key)) {
=======
		if(size == 0) {
>>>>>>> 16263f2b5f2c1b4fc5c1f842227e74a242adbd38
			return null;
		}
		
		Node current = findNode(key);
<<<<<<< HEAD
		Node successor;
		
		Value data = current.data;
		
		//I had found this algorithm for removal from the book Introduction to Algorithms,  0-262-03293-7
		//I had already written this a had it working, but for some reason I have no backup of it on Github and have managed to 
		//somehow delete any trace of it
		
		if(current.leftChild == null) {
			shiftNodes(current, current.leftChild);
		}
		else if(current.rightChild == null) {
			shiftNodes(current, current.rightChild);
		}
		else {
			successor = findSuccessor(current);
			
			Node successorParent = findParent(successor.key);
			
			if(!successorParent.key.equals(current.key)) {
				shiftNodes(successor, successor.rightChild);
				successor.rightChild = current.rightChild;
			}
			
			shiftNodes(current, successor);
			successor.leftChild = current.leftChild;
=======
		Node currentParent = findParent(key);
		Value data = current.data;
		
		//no children
		if(current.leftChild == null && current.rightChild == null) {
			current = null;
		}
		//1 child
		else if (current.leftChild != null ^ current.rightChild != null) {
			if(current.leftChild != null) {
				current = current.leftChild;
				
			}
			else {
				current = current.rightChild;
			}
			
			//set parent to point to new current
			if(comparator.compare(key, currentParent.key) < 0) {
				currentParent.leftChild = current;
			}
			else {
				currentParent.rightChild = current;
			}
		}
		//2 children
		else {
			
>>>>>>> 16263f2b5f2c1b4fc5c1f842227e74a242adbd38
		}
		
		size--;
		return data;
<<<<<<< HEAD
=======
		
>>>>>>> 16263f2b5f2c1b4fc5c1f842227e74a242adbd38
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
