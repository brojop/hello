package unl.soc;

public class MyLinkedList<E>  {

  // Define a nested class that is used only inside this class
  // https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
  private class Node<E> {
	    E element;
	    Node<E> next;
	    
	    public Node(E element) {
	      this.element = element;
	    }
  }
	
  private Node<E> head;  // First element in the list
  private Node<E> tail;  // Last  element in the list
  private int size = 0;  // Number of elements in the list
  
  /** Create an empty list */
  public MyLinkedList() {
  }

  /** Add an element to the beginning of the list */
  public void addFirst(E e) {
    Node<E> newNode = new Node<>(e); // Create a new node

    if (size == 0) {    // the new node is the only node in list
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head; // link the new node with the head
      head = newNode;      // head points to the new node
    }

    size++;                // Increase list size
  }

  /** Add an element to the end of the list */
  public void addLast(E e) {
    Node<E> newNode = new Node<>(e); // Create a new node

    if (size == 0) {	     // The new node is the only node in list
      head = newNode; 
      tail = newNode; 
    } else {
      tail.next = newNode;   // Link the new with the last node
      tail = newNode;        // tail now points to the last node
    }

    size++;                  // Increase list size
  }

  /** Add a new element at the end of this list 
   * Returns true if this collection changed as a result of the call. 
   * Returns false if this collection does not permit duplicates and 
   * already contains the specified element. */
  public boolean add(E e) {
	addLast(e);
    return true;
  }

  /** Add a new element at the specified index 
   * in this list. The index of the head element is 0 */
  public void add(int index, E e) {
	// Ensure the index is in the right range
	if (index < 0 || index > size)
        throw new IndexOutOfBoundsException
	       ("Index: " + index + ", Size: " + size);

    if (index == 0) {
      addFirst(e);
    }
    else if (index == size) {
      addLast(e);
    }
    else {
      Node<E> previous = getNode(index-1);
      Node<E> newNode = new Node<>(e); // Create a new for element e
      newNode.next = previous.next;
      previous.next = newNode;
      size++;
    }
  }

  /** Check whether index is valid */
  private void checkIndex(int index) {
	    if (index < 0 || index >= size)
	      throw new IndexOutOfBoundsException
	        ("Index: " + index + ", Size: " + size);
	  }

  /** Clear the list */
  public void clear() {
    size = 0;
    head = null;
    tail = null;
  }

  /** Return true if this list contains the element e */
  public boolean contains(Object e) {
	  Node<E> current = head;
      while (current != null) {
          if (current.element.equals(e)) {
              return true;
          }
          current = current.next;
      }
      return false;
  }

  /** Return the element at the specified index */
  public E get(int index) {
    Node<E> current = getNode(index);
    return current.element;
  }

  /** Return the node at the specified index */
  private Node<E> getNode(int index) {
    checkIndex(index);
    
    Node<E> current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    
    return current;
  }

  
  /** Return the head element in the list */
  public E getFirst() {
    if (size == 0) {
      return null;
    }
    else {
      return head.element;
    }
  }

  /** Return the last element in the list */
  public E getLast() {
    if (size == 0) {
      return null;
    }
    else {
      return tail.element;
    }
  }

  /** Return the index of the first matching element in 
   *  this list. Return -1 if no match. */
  public int indexOf(Object e) {
	  Node<E> current = head;
      int index = 0;
      while (current != null) {
          if (current.element.equals(e)) {
              return index;
          }
          current = current.next;
          index++;
      }
      return -1; // Element not found
  }

  /** Return true if this list contains no elements */
  public boolean isEmpty() {
    return size() == 0;
  }

  /** Return the index of the last matching element in 
   *  this list. Return -1 if no match. */
  public int lastIndexOf(E e) {
	  Node<E> current = head;
      int lastIndex = -1;
      int index = 0;
      while (current != null) {
          if (current.element.equals(e)) {
              lastIndex = index;
          }
          current = current.next;
          index++;
      }
      return lastIndex;
  }

  /** Remove the head node and
   *  return the object that is contained in the removed node. */
  public E removeFirst() {
    if (size == 0) {
      return null;
    } else if (size == 1) {
      E old = head.element;
      head = null;
      tail = null;
      size = 0;
      return old;
    } else {
      E old = head.element;
      head = head.next;
      size--;
      return old;
    }
  }

  /** Remove the last node and
   * return the object that is contained in the removed node. */
  public E removeLast() {
	  if(size == 0) {
		  System.out.println("List is empty");
	  } else if (size == 1) {
		  head = tail = null;
		  size = 0;
	  } else {
		  Node temp = head;
		  for (int i = 0; i < size - 2; i++) {
			  temp = temp.next;
		  }
		  tail = temp;
		  tail.next = null;
		  size--;
	  }
      return null;
  }

  /** Remove the element at the specified position in this 
   *  list. Return the element that was removed from the list. */
  public E remove(int index) {   
	checkIndex(index);

    if (index == 0) {
      return removeFirst();
    }
    else if (index == size - 1) {
      return removeLast();
    }
    else {
      Node<E> previous = getNode(index-1);
   	  Node<E> current = previous.next;
      previous.next = current.next;
      size--;
      return current.element;
    }
  }

  /** Remove the first occurrence of the element e 
   *  from this list. Shift any subsequent elements to the left.
   *  Return true if the element is removed. */
  public boolean remove(Object e) {
	Node<E> current = head;
	Node<E> previous = null;

	int i;
	for (i = 0; i < size; i++) {
		if (e.equals(current.element)) 
			break;
		previous = current;
		current = current.next;
	}

	if (i == size)
	  return false;
	
    if (size == 1) {
      head = null;
      tail = null;
    } else if (i == 0) {
      head = head.next;
    } else if (i == size - 1) {
      previous.next = null;
      tail = previous;
    } else {
  	  previous.next = current.next;
    }
    size--;
    return true;  
  }

  /** Replace the element at the specified position 
   *  in this list with the specified element. */
  public E set(int index, E e) {
	Node<E> current = getNode(index);
	E old = current.element;
	current.element = e;
    
	return old;
  }

 
  /** Return the number of elements in this list */
  public int size() {
    return size;
  }

  /** Return a string of the elements */
  public String toString() {
    StringBuilder result = new StringBuilder("[");

    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      result.append(current.element);
      if (i < size-1) 
        result.append(", "); // Separate two elements with a comma
      current = current.next;
    }
    result.append("]");      // Insert the closing ] in the string

    return result.toString();
  }

  public static void main(String[] args) {
	    MyLinkedList<Integer> list = new MyLinkedList<>();
	    list.add(10);
	    list.add(11);
	    list.add(12);
	    list.add(11);
	    list.add(13);
	    System.out.println("list = "+list);
	    System.out.println("contains(11) = "+list.contains(11));
	    System.out.println("indexOf(11) = "+list.indexOf(11));
	    System.out.println("lastIndexOf(11) = "+list.lastIndexOf(11));
	    list.removeLast();   
	    System.out.println("after removeLast(): "+list);
	  }

}

