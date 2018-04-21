/**
 * 
 */
package Lists;

/**
 * @author Daniel Acuña Mora
 * @param <T>
 *
 */
public class DoubleNode<T> {
	private T obj;
	private DoubleNode<T> next;
	private DoubleNode<T> prev;

	/**
	 * @param name
	 * @param next
	 * @param prev
	 */
	public DoubleNode(T name) {
		this.obj = name;
		this.next=null;
		this.prev=null;
	}

	public void setNext(DoubleNode<T> next) {
		this.next = next;
	}

	public void setPrev(DoubleNode<T> prev) {
		this.next = prev;
	}

	public T getObj() {
		return obj;
	}
	public DoubleNode<T> getNext() {
		return this.next;
	}
	public DoubleNode<T> getPrev() {
		return this.prev;
		
	}
}
