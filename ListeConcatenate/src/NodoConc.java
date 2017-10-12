/**
 *
 * @author simone.bolzonella
 */
public class NodoConc<T> {
	T info;
	NodoConc<T> next;

	public NodoConc(T info, NodoConc<T> next) {
		this.info = info;
		this.next = next;
	}

	public NodoConc() {
		this(null);
	}

	public NodoConc(T info) {
		this(info,null);
	}

	public T getInfo() {
		return info;
	}

	public NodoConc<T> getNext() {
		return next;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public void setNext(NodoConc<T> next) {
		this.next = next;
	}

}
