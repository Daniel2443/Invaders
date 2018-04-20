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
	private int size=0;

	public void add(T obj) {
		this.size +=1;

		if (head == null) {
			this.head = new SimpleNode<T>(obj);
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
	public void remove(T dato){
		SimpleNode<T> nodo = this.head;
		if(nodo.getObj() == dato){
			this.head = nodo.getNext();
			size --;
		}else{
			while(nodo.getNext()!= null){
				if(nodo.getNext().getObj() == dato){
					nodo.linkNext(nodo.getNext().getNext());
					size --;
//					if(nodo.getNext() == null){
//						this.tail = nodo;
//					}
					break;
				}else{
					nodo = nodo.getNext();
				}
			}
		}
}

	public T get(int i){
	    int count = 0;
	    SimpleNode<T> temporal = this.head;
	
	    while (count < i){
	        temporal = temporal.getNext();
	        count++;
	    }
	    return temporal.getObj();
	}
	
}
