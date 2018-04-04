/**
 * 
 */
package Lists;

/**
 * @author Daniel Acuña Mora
 *
 */
public class SimpleNode<T> {
	private T name;
	private SimpleNode<T> next;
	private SimpleNode<T> prev;

	/**
	 * @param name
	 * @param next
	 * @param prev
	 */
	public SimpleNode(T name) {
		this.name = name;
	}

	public void linkNext(SimpleNode<T> next) {
		this.next = next;
	}

	public void linkPrev(SimpleNode<T> prev) {
		this.next = prev;
	}

	public T getName() {
		return name;
	}
}
