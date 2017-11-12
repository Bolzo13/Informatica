/**
 *
 * @author simone.bolzonella
 */
public class NodoLista <T> {
    T info;
    NodoLista next;
    NodoLista(T info, NodoLista next) {
        this.info=info;
        this.next=next;
	}
}