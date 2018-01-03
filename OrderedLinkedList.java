package project2;

public class OrderedLinkedList  <E extends Comparable<E>>  implements OrderedList<E> {
	private Node<E> head;
	private Node<E> tail;
	int size;
	//create a node class
	private static class Node<E> {
		private E element;
		private Node<E> next;
		
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}
		//access data at node
		public E getElement() {
			return element;
		}
		public Node<E> getNext() {
			return next;
		}
	}
	
	
	 public boolean add(E e) { 
		 //ClassCastException will not be thrown because E extends Comparable, without which the list could not be created
		 
 	    //if e is null
 	    if (e == null) {
 	    	    throw new NullPointerException("ERROR: NullPointerException.");
 	    }
 	    
 	    
 	    Node<E> newNode = new Node<E> (e, null);
 	    Node<E> current = head;
 	    
 	    //adding to empty list
 	    if (current == null) {
 	    	    newNode.next = null;
 	    	    tail = newNode;
 	    	    head = newNode;
 	    	    size ++;
 	    	    return true;
 	    }
 	    
 	    //one node in list
 	    if (current.next == null) {
 	    	    if (newNode.getElement().compareTo(current.getElement()) > 0) {
 	    	    	    newNode.next = null;
 	    	    	    current.next = newNode;
 	    	    	    tail = newNode;
 	    	    	    size ++;
 	    	    	    return true;
 	    	    }
 	    	    else {
 	    	    	    newNode.next = current;
 	    	    	    head = newNode;
 	    	    	    tail = current;
 	    	    	    size ++;
 	    	    	    return true;
 	    	    }
 	    }
 	    
 	       //adding to end of list
	    	       if(newNode.getElement().compareTo(tail.getElement()) > 0) {
	    	    	       tail.next = newNode;
	    	    	    	   newNode.next = null;
	    	    	    	   tail = newNode;
	    	    	    	   size ++;
	    	    	    	   return true;
	    	    	    }
	    	       //adding in front of head
	    	       if(newNode.getElement().compareTo(head.getElement()) < 0) {
    	    	    	       newNode.next = head;
    	    	    	       head = newNode;
    	    	    	       size ++;
    	    	    	       return true;
    	    	    }
 	    
		//adding to a list with more than 1
 	    //checking where to add
 	    else {
 	    	
 	    	while (current.next != null) {
 	    
 	        if (newNode.getElement().compareTo(current.getElement()) > 0 && newNode.getElement().compareTo(current.next.getElement()) < 0) {
 			   newNode.next = current.getNext();
 			   current.next = newNode;
 			   size ++;
 			   return true;
 		   }
 		   else {
 			   current = current.getNext();
 		   }
 	     }
 	    	return false;
 	    }
	 }
	 
	 public void clear() {
		head = null;
		size = 0;
 }
	 
	 //from the book
	 public Object clone() throws CloneNotSupportedException {
		 OrderedLinkedList<E> other = (OrderedLinkedList<E>) super.clone();
		 if (size > 0) {
			 other.head = new Node<>(head.getElement(), null);
			 Node<E> walk = head.getNext();
			 Node<E> otherTail = other.head;
			 while (walk!= null) {
				 Node<E> newest = new Node<>(walk.getElement(), null);
				 otherTail.next = newest;
				 otherTail = newest;
				 walk = walk.getNext();
			 }
		 }
		 return other;
		 
		}
	 
	 public boolean contains(Object o) { 
		 Node<E> current = head;
	 	    
	 	 while (current.next != null) {
	 		 
	 	    	 //check if current is same as o
	 	    	 if (current.getElement().equals(o)) {
	 	    		 return true;
	 	    	 }
	 	    	 //if not set current to next node
	 	    	 current = current.getNext();
	 	 }
	 	 return false;
 }
	 //from the book
	 public boolean equals(Object o) {
		 if (o == null) {
			 return false;
		 }
		 if (getClass() != o.getClass()) {
			 return false;
		 }
		 OrderedLinkedList other = (OrderedLinkedList) o;
		 if (size != other.size() ) {
			 return false;
		 }
		 Node walkA = head;
		 Node walkB = other.head;
		 while (walkA != null) {
			 if (!walkA.getElement().equals(walkB.getElement())) {
				 return false;
			 }
			 walkA = walkA.getNext();
			 walkB = walkB.getNext();
		 }
		 return true;
	 }
	    
	 
	 public E get(int index) { 
 	    Node<E> current = head;
 	    int counter = 0;
 	    
 	    if (index < 0 || index >= size()) {
 	      	throw new IndexOutOfBoundsException("ERROR: Index out of bounds");
 	    }
 	    
 	    while (current != null && counter < size) {
 	    	    if (counter == index) {
 	    	    	    return current.getElement();
 	    	    }
 	    	    else {
 	    	    counter ++;
 	    	    current = current.getNext();
 	    	    }
 	    }
 	    System.out.println(size);
 	   return null; 
 }
	 
	 public int indexOf (Object o) { 
		 Node<E> current = head;
	 	 int index = 0;
	 	 
	 	 while (current != null) {
	 		 if (current.getElement() == o) {
	 			 return index;
	 		 }
 	    	     current = current.getNext();
 	    	     index ++;
	 	 }
	 	 return -1;
	 }
	 
	    public E remove (int index) {
	    	    Node<E> current = head;
	    	    int i = 0;
	    	    
	    	    if(index < 0 || index >= size()) {
	     	    	throw new IndexOutOfBoundsException("ERROR: Index out of bounds");
	     	    }
	    	    
	    	    //removing head
	    	    if (index == 0) {
	    	    	      	E temp;
	    	    	    	    temp = current.getElement();
	    	    	        head = head.getNext();
	    	    	        size --;
	    	    	        return temp;
	    	    }
	    	    
	    	    //removing tail
	    	    else if (index == (size() -1)) {
	    	       	E temp;
    	    	        temp = tail.getElement();
	    	    	    	    while (current != null) {
	    	    	    	    	    if (i == index - 1) {
	    	    	    	    	    	    current.next = null;
	    	    	    	    	    	    tail = current;
	    	    	    	    	    	    size --;
	    	    	    	    	    }
	    	    	    	    	    else {
	    	    	    	    	    	    current = current.getNext();
	    	    	    	    	    	    i ++;
	    	    	    	    	    }
	    	    	    	    }
	    	    	    	    return temp;
	    	    }
	    	    
	    	    //removing other index
	    	    else {
	    	    	    E temp = current.next.getElement();
	    	    	    while (current != null) {
	    	    	    	    if (i == index - 1) {
	    	    	    	    	    temp = current.next.getElement();
	    	    	    	    	    current.next = current.getNext().getNext();
	    	    	    	    	    size --;
	    	    	    	    }
	    	    	    	    else {
	    	    	    	    	    i ++;
	    	    	    	    	    current = current.getNext();
	    	    	    	    }
	    	    	    }
	    	    	    return temp;
	    	    }
	    	    
	    }
	    
	    public boolean remove (Object o) {
	    	    Node<E> current = head;
	    	    while (current != null) {
	    	    	    if (current.next.getElement().equals(o)) {
	    	    	    	    current.next = current.getNext().getNext();
	    	    	    	    return true;
	    	    	    }
	    	    	    else {
	    	    	    	    current = current.getNext();
	    	    	    }
	    	    }
	    	    return false;
	    }

	    public int size() { 
	        return size;
	    }
	    
	    public String toString() { 
	    	    String list_string = "";
	    	    Node<E> current = head;
	    	    while (current != null) {
	    	    	    list_string += current.getElement().toString();
	    	    	    current = current.getNext();
	    	    }
	    	    return list_string;
        }  
}