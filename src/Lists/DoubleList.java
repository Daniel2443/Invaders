/**
 * 
 */
package Lists;

/**
 * @author Daniel Acuña Mora
 *
 */
public class DoubleList <T>{
	private DoubleNode<T> head;
	private DoubleNode<T> tail;
	private int size;
	public int positionEnemy;
	public int positionBoss;
	public int position;
	public DoubleList(){
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
	public void add(T dato){
		size ++;
		if(this.head == null){
			this.head = new DoubleNode<T>(dato);
			this.tail = head;
		}else{
			DoubleNode<T> temp = this.tail;
			temp.setNext(new DoubleNode<T>(dato));
			temp.getNext().setPrev(temp);
			this.tail = temp.getNext();
		}
	}
	/**
	 * Metodo para borrar datos
	 * @param dato
	 */
//	public void remove(T dato){
//		DoubleNode<T> nodo = this.head;
//		while(nodo != null){
//			if(nodo.getObj() == dato){
//				if(nodo != head && nodo.getNext() == null){
//					nodo.getPrev().setNext(null);
//					this.tail = nodo.getPrev();
//					size --;
//				}else if(nodo == head){
//					if(nodo.getNext() == null){
//						this.head = null;
//						this.tail = null;
//						size --;
//					}else{
//						this.head = nodo.getNext();
//						nodo.getNext().setPrev(null);
//						size --;
//					}
//				}else if(nodo != head && nodo.getNext() != null && nodo.getPrev() != null){
//					nodo.getPrev().setNext(nodo.getNext());
//					nodo.getNext().setPrev(nodo.getPrev());
//					size --;
//				}
//				break;
//			}else{
//				nodo = nodo.getNext();
//			}
//		}
//	}
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
	
	public void search(T num) {
		position = 0;
		DoubleNode<T> temp = this.head;
		while(temp != null){
			if(temp.getObj() == num){
				if(temp == this.head) {
					System.out.println("El numero " + num + " esta en la posicion " + position);
					break;
				}else {
					System.out.println("El numero " + num + " esta en la posicion " + position);
					break;
				}
			}else {
				temp = temp.getNext();
				position ++;
			}
		}
	}
	
	 
}
