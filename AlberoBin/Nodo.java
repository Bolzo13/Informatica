/**
 *
 * @author simone.bolzonella
 */
public class Nodo <T> {
	T info;
	Nodo sinistra;
	Nodo destra;
	public Nodo(T info, Nodo left, Nodo right) {
		this.info = info;
		this.sinistra = left;
		this.destra = right;
	}
}
