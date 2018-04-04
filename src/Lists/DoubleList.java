/**
 * 
 */
package Lists;

/**
 * @author Daniel Acuña Mora
 *
 */
public class DoubleList<T> {
	
	private DoubleNode<T> head;
	private DoubleNode<T> tail;
	private int size;
	/*
	 * (non-Javadoc)
	 * 
	 * @see Lists.Lists#addFisrst()
	 */
	public void addFirst(T name) {
		if (head == null) {
			DoubleNode<T> node = new DoubleNode<T>(name);
			this.head = node;
			this.tail = node;
			this.size += 1;
		} else {
			DoubleNode<T> temp = this.head;
			DoubleNode<T> node = new DoubleNode<T>(name);
			node.linkNext(temp);
			temp.linkPrev(node);
			this.head = node;
			this.tail = temp;
			this.size += 1;
		}

	}
	public T getEnemyIndex(){
		
		return this.head.getObj();
	}
	public void deleteFirst() {
		if (this.head == null) {
			throw new NullPointerException("No hay ningún nodo");
		}
		else {
			head = head.getNext();
			
		}
		
	}
}
