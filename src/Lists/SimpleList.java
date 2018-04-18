/**
 * 
 */
package Lists;

/**
 * @author Daniel Acuña Mora
 *
 */
public class SimpleList<T> {
	private SimpleNode<T> head;
	private int size;

	public void addFirst(T obj) {
		if (head == null) {
			SimpleNode<T> node = new SimpleNode<T>(obj);
			this.head = node;
			this.size += 1;

		} else {
			SimpleNode<T> temp = this.head;
			SimpleNode<T> node = new SimpleNode<T>(obj);
			node.linkNext(temp);
			this.head = node;

		}

	}

	public T getFirst() {
		return this.head.getObj();
	}

	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}
//	public T (int i) {
//		SimpleNode<T> temp = this.head;
//		if(i>this.size) {
//			new IllegalArgumentException("El numero ingresado no es valido, por que excede el tamaño de la lista");
//		}
//		else {
//			int c=0;
//			while(c<i) {
//				temp.linkNext(temp.getNext());
//			}
//		}
//		return temp.getObj();
//
//	}
	public int size() {
		return this.size;
	}
	
}
