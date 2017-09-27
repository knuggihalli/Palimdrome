/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Palimdrome;

import java.util.NoSuchElementException;

/*
 * Implement a reference based queue
 */
public class Queue<E> {
	
	private Node<E> front;
	private Node<E> back;
        int size;

	public Queue() {
            this.front = null;
            this.back  = null;
            size = 0;
	}
	
	
	/*
	 * places element in the back of the Queue
	 */
	public void enqueue(E element){
            Node<E> oldlast = back;
            back = new Node<E>();
            back.setElement(element);
            back.next = null;
            if (isEmpty()) front = back;
            else oldlast.next = back;
            size++;
	}
	
	/*
	 * remove the front node of the queue and return it
	 */
	public E dequeue(){
            if (isEmpty()) throw new NoSuchElementException("Queue underflow");
            E item = front.getElement();
            front = front.next;
            size--;
            if (isEmpty()) back = null;   // to avoid loitering
            return item;
	}
	
	/*
	 * Look at the front of the queue and return it, without removing
	 */
	public E peek(){
            if (isEmpty()) throw new NoSuchElementException("Queue underflow");
            return front.getElement();
	}
	
	//returns the size of the queue
	public int size(){
		return size;  //replace
	}
        
        //just check if font == null
        public boolean isEmpty() {
            return front == null;
        }

}