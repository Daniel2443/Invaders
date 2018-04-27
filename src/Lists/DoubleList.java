/**
 * 
 */
package Lists;

import Enemies.Recruit;
import UI.Game;

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
	private String type;
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
	 * Añade cualquier tipo de dato, haciendo referencias a los nodos
	 * anterior u siguiente.
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
	 * @param dato
	 */
	
	public void remove(T dato){
		DoubleNode<T> node = this.head;
		while(node != null){
			if(node.getObj() == dato){
				if(node != head && node.getNext() == null){
					node.getPrev().setNext(null);
					this.tail = node.getPrev();
					size --;
				}else if(node == head){
					if(node.getNext() == null){
						this.head = null;
						this.tail = null;
						size --;
					}else{
						this.head = node.getNext();
						node.getNext().setPrev(null);
						size --;
					}
				}else if(node != head && node.getNext() != null && node.getPrev() != null){
					node.getPrev().setNext(node.getNext());
					node.getNext().setPrev(node.getPrev());
					size --;
				}
				break;
			}else{
				node = node.getNext();
			}
		}
}
	/**
	 * Elimina las referencias del head, lo convierte a nulo y cambia el tamaño de lista 
	 * a 0;
	 */
	public void clear() {
		this.head.setNext(null);
		this.head = null;
		this.size =0;
	}
	/**
	 * Si la lista tiene un tamaño 0, devuelve true.
	 * @return
	 */
	public boolean isEmpty() {
		if(this.size==0) {
			return true;
		}
		else {
		return false;}
	}
	/**
	 * Obtiene los nodos por su indice y devuelve el objeto asociado
	 * al mismo.
	 * 
	 * @param i
	 * @return
	 */
	
	public T get(int i) {
		int cont = 0;
		DoubleNode<T> temp = this.head;
		while(cont < i) {
			temp = temp.getNext();
			cont ++;
		}
		return temp.getObj();
	}
	
	
//	public void search(T num) {
//		position = 0;
//		DoubleNode<T> temp = this.head;
//		while(temp != null){
//			if(temp.getObj() == num){
//				if(temp == this.head) {
//					System.out.println("El numero " + num + " esta en la posicion " + position);
//					break;
//				}else {
//					System.out.println("El numero " + num + " esta en la posicion " + position);
//					break;
//				}
//			}else {
//				temp = temp.getNext();
//				position ++;
//			}
//		}
//	}
//	public void change2(int i, int m) {
//		
//		
//	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}	
	public void search(int e) {
		position = 0;
		DoubleNode<T> temp = this.head;
		while(temp != null){
			if(temp.ID == e){
				break;
			}else {
				temp = temp.getNext();
				position ++;
			}
		}
		if (Game.getDouble().size == position) {
			position = 0;
		}
	}
	public DoubleNode<T> getNodo(int i) {
		int cont = 0;
		DoubleNode<T> temp = this.head;
		while(cont < i) {
			temp = temp.getNext();
			cont ++;
		}
		return temp;
}
	public void change(int boss, int enemy) {
		search(boss);
		positionBoss = position;
		System.out.println(positionBoss);
		search(enemy);
		positionEnemy = position;
		System.out.println(positionEnemy);
		Recruit temp = Game.getDouble().getNodo(positionBoss).getObj();
		Recruit temp1 = Game.getDouble().getNodo(positionEnemy).getObj();
		Game.getDouble().getNodo(positionEnemy).setObj(temp);
		Game.getDouble().getNodo(positionBoss).setObj(temp1);
		int n1 = temp.n;
		int n2 = temp1.n;
		int m1 = temp.m;
		int m2 = temp1.m;
		int x1 = temp.x;
		int x2 = temp1.x;
		int ID1 = temp.ID;
		int ID2 = temp.ID;
		temp.n = n2;
		temp1.n = n1;
		temp.m = m2;
		temp1.m = m1;
		temp.x = x2;
		temp1.x = x1;
		temp.ID = ID2;
		temp1.ID = ID1;
}
	
	 
}
