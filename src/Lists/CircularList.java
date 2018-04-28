/**
 * 
 */
package Lists;

import javax.swing.tree.AbstractLayoutCache.NodeDimensions;

/**
 * @author Daniel Acuña Mora
 * @param <T>
 *
 */
public class CircularList<T> {

	private CircularNode<T> head;
	private CircularNode<T> tail;
	private int size;

	/**
	 * Agrega un nodo al inicio, y asocia un objeto al mismo.
	 */
	public void addFirst(T name) {
		if (head == null) {
			CircularNode<T> node = new CircularNode<T>(name);
			this.head = node;
			this.tail = node;
			this.size += 1;
		} else {
			CircularNode<T> temp = this.head;
			CircularNode<T> node = new CircularNode<T>(name);
			node.linkNext(temp);
			temp.linkPrev(node);
			this.head = node;
			this.tail.linkNext(this.head);
			this.size += 1;
		}

	}

	public T getFirstEnemy() {
		return this.head.getObj();
	}

	public int getSize() {
		System.out.println(this.size);
		return this.size;
	}

}
