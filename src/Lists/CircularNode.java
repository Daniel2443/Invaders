/**
 * 
 */
package Lists;

/**
 * @author Daniel Acuña Mora
 *
 */
public class CircularNode<T> {
	private T obj;
	private CircularNode<T> next;
	private CircularNode<T> prev;

	/**
	 * @param name
	 * @param next
	 * @param prev
	 */
	public CircularNode(T name) {
		this.obj = name;
	}

	public void linkNext(CircularNode<T> next) {
		this.next = next;
	}

	public void linkPrev(CircularNode<T> prev) {
		this.next = prev;
	}

	public T getObj() {
		return obj;

	}

}
