/**
 * 
 */
package Main;

import Lists.DoubleNode;

/**
 * @author Daniel Acuña Mora
 *
 */
public class ListaDoble <T>{
	private DoubleNode<T> head;
	private DoubleNode<T> tail;
	private int size;
	public int positionEnemy;
	public int positionBoss;
	public int position;
	public ListaDoble(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	/**
	 * Getters and setters
	 * @return
	 */
	public DoubleNode<T> getHead() {
		return head;
	}
	public int size() {
		return this.size;
	}

	/**
	 * Matodo para añadir datos
	 * @param dato
	 */
	public void add(T dato,int id){
		size ++;
		if(this.head == null){
			this.head = new DoubleNode<T>(dato,id);
			this.tail = head;
		}else{
			DoubleNode<T> temp = this.tail;
			temp.setNext(new DoubleNode<T>(dato,id));
			temp.getNext().setPrev(temp);
			this.tail = temp.getNext();
		}
	}
	/**
	 * Metodo para eliminar datos específicos.
	 * @param dato
	 */
	public void remove(T dato) {
		DoubleNode<T> nodo =this.head;
		if(nodo.getObj() == dato){
			this.head = nodo.getNext();
			size --;
		}else{
			while(nodo.getNext()!= null){
				if(nodo.getNext().getObj() == dato){
					nodo.setNext(nodo.getNext().getNext());
					size --;
					break;
				}else{
					nodo = nodo.getNext();
				}
			}
		}
	}	
	/**
	 *
	 */
	public void printList(){
		DoubleNode<T> actual = this.head;
		while(actual != null){
			System.out.println(actual.getObj());
			actual = actual.getNext();
		}
}
	
	public void deleteAll() {
		this.head.setNext(null);
		this.head = null;
		this.size =0;
	}
	public boolean isEmpty() {
		if(this.size==0) {
			return true;
		}
		else {
		return false;}
	}
	
	
	public T get(int i) {
		int cont = 0;
		DoubleNode<T> temp = this.head;
		while(cont < i) {
			temp = temp.getNext();
			cont ++;
		}
		return temp.getObj();
	}
	
	
	public int search(T num) {
		position = 0;
		DoubleNode<T> temp = this.head;
		while(temp != null){
			if(temp.getObj() == num){
				return position;
				}
			else {
				temp = temp.getNext();
				position ++;
			}
		}
		return position;
	}
	
	public void changeP(T a,T b) {
		  T temp1 = get(search(a));
		  T temp2 = get(search(b));
		  
		  DoubleNode<T> nodo = new DoubleNode<>(temp1);
		  DoubleNode<T> nodo2 = new DoubleNode<>(temp2);
		  
		  
		
		
	}
	
	 
}