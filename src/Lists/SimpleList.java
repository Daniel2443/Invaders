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
	
	public int size() {
		return this.size;
	}
	/**
	 * Remueve un nodo a partir del objeto que hay en él.
	 * Compara cada objeto con el introducido, y al encontrarlo 
	 * elimina el nodo que lo contiene.
	 * 
	 * @param obj
	 */
	public void remove(T obj){
		SimpleNode<T> nodo = this.head;
		if(nodo.getObj() == obj){
			this.head = nodo.getNext();
			size --;
		}else{
			while(nodo.getNext()!= null){
				if(nodo.getNext().getObj() == obj){
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
	/**
	 * Obtiene el objeto de un nodo, a partir de un indice especificado.
	 * Recorre los nodos y cuando llega al nodo deseado retorna el objeto dentro
	 * de ese nodo.
	 * @param i
	 * @return
	 */
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
